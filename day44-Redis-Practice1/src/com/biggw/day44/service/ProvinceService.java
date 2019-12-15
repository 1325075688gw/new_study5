package com.biggw.day44.service;

import com.biggw.day44.domain.Province;

import java.util.List;

/**
 * @author gw
 * @date 2019/11/26 0026 下午 13:51
 */
public interface ProvinceService {

    public List<Province> findAll();

    public String findAllJson();

    // 以后我们还可以在这里面提供添加省份的抽象方法，那时候，我们每次执行添加省份的Dao方法后，就需要操作Redis，1.要么清除Redis数据，2.要么给Redis添加数据
}
