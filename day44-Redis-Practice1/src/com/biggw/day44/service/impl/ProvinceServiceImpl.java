package com.biggw.day44.service.impl;

import com.biggw.day44.dao.ProvinceDao;
import com.biggw.day44.dao.impl.ProvinceDaoImpl;
import com.biggw.day44.domain.Province;
import com.biggw.day44.jedis.utils.JedisPoolUtils;
import com.biggw.day44.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author gw
 * @date 2019/11/26 0026 下午 13:52
 */
public class ProvinceServiceImpl implements ProvinceService {

    // 1.声明Dao
    ProvinceDao provinceDao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        List<Province> provinces = provinceDao.findAll();
        return provinces;
    }

    /**
     * 先查询Redis
     * @return
     */
    @Override
    public String findAllJson() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String provinces = jedis.get("provinces");
        // 如果缓存数据中没有数据，我们就必须查询数据库
        if(provinces == null || provinces.length() == 0){
            System.out.println("redis中有数据，查询缓存...");
            // 缓存里面没有数据，从MySQL中查询ing...
            List<Province> provinceList = findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                provinces = objectMapper.writeValueAsString(provinceList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            // 将MySQL数据库中查询到的数据，写入Redis中
            jedis.set("provinces", provinces);
            // 归还连接
            jedis.close();

            return provinces;
        }else{
            // 缓存中有数据，从Redis中查询ing...
            System.out.println("redis中有数据，查询缓存...");
            return provinces;
        }
    }
}
