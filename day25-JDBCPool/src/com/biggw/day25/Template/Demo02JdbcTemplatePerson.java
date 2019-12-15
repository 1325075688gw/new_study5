package com.biggw.day25.Template;

import com.biggw.day25.utils.JdbcDruidUtils;
import javafx.beans.property.adapter.JavaBeanObjectProperty;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author gw
 * @date 2019/11/16 0016 下午 23:02
 */


/*
 Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC的开发
 步骤：
	1. 导入jar包
	2. 创建JdbcTemplate对象。依赖于数据源DataSource
		* JdbcTemplate template = new JdbcTemplate(ds);

	3. 调用JdbcTemplate的方法来完成CRUD的操作
		* update():执行DML语句。增、删、改语句
		* queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
			* 注意：【这个方法查询的结果集长度只能是1】
		* queryForList():查询结果将结果集封装为list集合                                                    【 一次性可以查询多条记录 】
			* 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
		* query():查询结果，将结果封装为JavaBean对象                                                       【 一次性可以查询多条记录（更推荐） 】
			* query的参数：RowMapper
				* 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
				* new BeanPropertyRowMapper<类型>(类型.class)
		* queryForObject：查询结果，将结果封装为对象
			* 一般用于聚合函数的查询 【这个方法查询的结果集长度只能是1】
			* 【也可以用于单个Person对象的查询（用于登陆验证）】
 */
public class Demo02JdbcTemplatePerson {

    //    private DataSource dataSource = JdbcDruidUtils.getDataSource();
    // 我们在最上面创建JdbcTemplate对象，下面方法公用这个变量
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDruidUtils.getDataSource());



    /**
     * 修改1号数据的salary为6789
     */
    @Test
    public void test1() {
        System.out.println("==============  update: 修改  ===============");
        String sql = "update info set salary = ? where id = ?";
        int count = jdbcTemplate.update(sql, 6789, 1);
        System.out.println("count = " + count);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test2() {
        System.out.println("===============  update:添加  ==============");
        String sql = "insert into info values(?,?,?)";
        int count = jdbcTemplate.update(sql, 7, "绿巨人", 2333);
        System.out.println("count = " + count);
    }

    /**
     * 删除刚才添加的记录
     */
    @Test
    public void test3() {
        System.out.println("=============  update:删除  ================");
        String sql = "delete from info where id =?";
        // 没有 * 号
        // String sql = "delete * from info where id =?";
        int count = jdbcTemplate.update(sql, 7);
        System.out.println("count = " + count);
    }

    /**
     * 查询id为1的记录,将其封装为Map集合(键值对,就是Python里面的字典)
     * 查询结果集长度只能为1
     */
    @Test
    public void test4() {
        System.out.println("==============   queryForMap: 封装为Map  ===============");
        String sql = "select * from info where id = ?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql,1);
        System.out.println("stringObjectMap = " + stringObjectMap);
    }

    /**
     * 查询所有记录,将其封装为List集合,(每个集合都是Map对象)
     */
    @Test
    public void test5() {
        System.out.println("============  queryForList: 封装为List(每一个对象仍然是Map对象)    =================");
        String sql = "select * from info";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }


    /**
     * 查询所有记录,将所有记录封装为Perosn对象,然后装到List集合
     */
    @Test
    public void test6_1() {
        System.out.println("==============  query: 封装为List(自己封装)    ===============");
        String sql = "select * from info";
        //     <T> List<T> query(String var1, RowMapper<T> var2) throws DataAccessException;
        List<Person> personList = jdbcTemplate.query(sql, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");

                Person person = new Person(id, name, salary);
                return person;
            }
        });
        for (Person person : personList) {
            System.out.println(person);
        }
    }


    /**
     * 查询所有记录,将所有记录封装为Perosn对象,然后装到List集合
     * 使用匿名函数
     */
    @Test
    public void test6_2() {
        System.out.println("==============   query: 封装为List(自己封装,使用lambda接口编程)   ===============");
        String sql = "select * from info";
        //     <T> List<T> query(String var1, RowMapper<T> var2) throws DataAccessException;
        List<Person> personList = jdbcTemplate.query(sql,(ResultSet resultSet, int val)->{
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double salary = resultSet.getDouble("salary");

            Person person = new Person(id, name, salary);
            return person;
        });
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    /**
     * 查询所有记录,将所有记录封装为Perosn对象,然后装到List集合
     */
    // todo 从数据库中查询，从下到上的封装
    @Test
    public void test6_3() {
        System.out.println("=============   query: 封装为List,使用BeanPropertyRowMapper   ================");
        String sql = "select * from info";

        // List<Person> personList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<需要封装的类型>(需要封装的类型.class));
        List<Person> personList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
        for (Person person : personList) {
            System.out.println(person);
        }

        // 这种是封装一个对象，好奇怪，验证登陆用（只能查询一个用户？）             【 错了，一个和多个都可以查询 】
        Person person = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Person>(Person.class));
        System.out.println("person = " + person);


        /*
        如果SQL语句中有参数，我们这样写
                String sql = "select * from info where id = ?";

        // List<Person> personList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<需要封装的类型>(需要封装的类型.class));
        List<Person> personList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Person>(Person.class),"小强");
        for (Person person : personList) {
            System.out.println(person);
        }
         */
    }

    /**
     * 查询记录总数
     */
    @Test
    public void test7() {
        System.out.println("==============   queryForObject: 聚合函数查询   ===============");
        String sql = "select count(id) from info";

        // jdbcTemplate.queryForObject(sql, 包装或者引用类型的.class);
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("count = " + count);
    }

    /**
     * 查询单条记录更推荐 queryForObject
     */
    public void test8(){
                String sql = "select * from User where username = ? and password = ?";
/*            List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class),
                     user.getUsername(),
                    user.getPassword());
            return query.get(0);*/


        Person user= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Person>(Person.class),
                "小亲爱那个",
                "123456");
        System.out.println("user = " + user);


    }

}

/**
 * version = '1.0' 也可以是1.1版本,但是1.1版本不向下兼容,所以我们就写1.0就好了
 * IDEA自动关联version的编码方式
 */
