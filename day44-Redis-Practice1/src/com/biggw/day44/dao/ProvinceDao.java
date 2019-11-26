package com.biggw.day44.dao;

import com.biggw.day44.domain.Province;

import java.util.List;

/**
 * @author gw
 * @date 2019/11/26 0026 下午 13:38
 */
public interface ProvinceDao {
    public List<Province> findAll();

    // 不需要再这里面定义查询Redis的抽象方法
    // public String findAllJson();
}
