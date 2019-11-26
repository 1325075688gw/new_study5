package com.biggw.day44.service.impl;

import com.biggw.day44.dao.ProvinceDao;
import com.biggw.day44.dao.impl.ProvinceDaoImpl;
import com.biggw.day44.domain.Province;
import com.biggw.day44.service.ProvinceService;

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
}
