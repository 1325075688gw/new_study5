package com.biggw;


import com.biggw.repositories.ArticleDao;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.biggw.domain.Article;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author gw
 * @date 2019/12/3 0003 下午 23:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataElasticSearchTest {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndex() throws Exception{
        // 创建索引，并配置映射关系
        template.createIndex(Article.class);
    }

    @Test
    public void creatDocument() throws Exception{
        Article article = new Article();
        article.setContent("哈哈哈");
        article.setId(3);
        article.setTitle("f");

        articleDao.save(article);
    }

    @Test
    public void testDelById(){
        articleDao.delete((long) 1);
    }


    // ES底层是Lucence，lucence的更新操作是先删除后添加，所以没有update一说
    @Test
    public void testUpdate(){
        Article article = new Article();
        article.setContent("哈哈哈");
        article.setId(3);
        article.setTitle("f");
        articleDao.save(article);
    }

    @Test
    public void testFindOne(){
        Article one = articleDao.findOne((long) 1);
        System.out.println("one = " + one);
    }

    @Test
    public void testFindMany(){
        Iterable<Article> all = articleDao.findAll();
        all.forEach(a-> System.out.println(a));
    }


    // 自定义查询函数，只要按照规则书写函数名即可
    @Test
    public void testFindByContent(){
        List<Article> hhh = articleDao.findByContent("你好小强");
        // 这种查询，会将“你好小强分词”，然后去查询，但是content中必须包含小强，和你好，顺序可以变，
        // 这时候就不满足我们有小强，就返回文档了，所以我们用原生语句查询 public void testNativeSearch(){}，这样我们文档中只要包含“小强”，我们就可以返回
    }


    // 分页查询
    // 默认带分页，每页10条数据，从0页开始
    @Test
    public void test(){
        Pageable pageRequest = new PageRequest(0, 15);
        List<Article> hhh = articleDao.findByContentOrTitle("hhh","3343",pageRequest);
    }

    // 原生语句查询
    public void testNativeSearch(){
        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(QueryBuilders.queryStringQuery("哈哈哈").defaultField("content"))
                .withPageable(new PageRequest(0, 5)).build();
        List<Article> articles = template.queryForList(build, Article.class);

    }
}
