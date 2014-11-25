package com.springapp.services.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.CityDao;
import com.springapp.domain.City;
import com.springapp.exception.DaoException;
import com.springapp.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/8/7.
 */
@Service("cityServiceImpl")
public class CityServiceImpl implements CityService {
    @Autowired
    public BaseDao baseDao;
    @Autowired
    public CityDao cityDao;
    @Override
    public void save(City obj) throws DaoException {
        baseDao.save(obj);
    }
    @Override
    public void delete(City obj) throws DaoException {
        baseDao.delete(obj);
    }
    @Override
    public void update(City obj) throws DaoException {
        baseDao.update(obj);
    }
    @Override
    public List<City> findAllCity(String hql) throws DaoException {
        return cityDao.findAllCity(hql);
    }

    @Override
    public List<City> findCityByCityEnglish(String hql) throws DaoException {
        return cityDao.findCityByCityEnglish(hql);
    }

    @Override
    public int findIdByEnglishName(String englishName) throws DaoException {
        return cityDao.findIdByEnglishName(englishName);
    }
}
