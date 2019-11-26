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

    // 以后我们还可以在这里面提供添加省份的抽象方法，那时候，我们的实现类，每次执行添加身份后，就需要操作Redis，要么清楚数据，要么给Redis添加数据
}
