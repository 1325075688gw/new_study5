package com.biggw.day44.dao.impl;

import com.biggw.day44.dao.ProvinceDao;
import com.biggw.day44.domain.Province;
import com.biggw.day44.utils.JdbcDruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author gw
 * @date 2019/11/26 0026 下午 13:40
 */
public class ProvinceDaoImpl implements ProvinceDao {

    // 1.获取连接池中的连接
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDruidUtils.getDataSource());

    /**
     * 查询所有的省份
     * @return
     */
    @Override
    public List<Province> findAll() {
        String sql = "select * from Province";
        List<Province> provinces = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return provinces;
    }
}
