package com.springapp.services;

import com.springapp.domain.City;
import com.springapp.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2014/8/7.
 */

public interface CityService {

    public void save(City obj) throws DaoException;

    public void delete(City obj) throws DaoException;

    public void update(City obj) throws DaoException;

    public List<City> findAllCity(String hql) throws DaoException;

    public List<City> findCityByCityEnglish(String hql) throws DaoException;

    public int findIdByEnglishName(String englishName) throws DaoException;

}
