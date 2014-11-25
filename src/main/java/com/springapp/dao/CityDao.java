package com.springapp.dao;

import com.springapp.domain.City;
import com.springapp.exception.DaoException;

import java.util.List;

public interface CityDao {

    public void save(City obj) throws DaoException;

    public void delete(City obj) throws DaoException;

    public void update(City obj) throws DaoException;

    public List<City> findAllCity(String hql) throws DaoException;

    public List<City> findCityByCityEnglish(String hql) throws DaoException;

    public int findIdByEnglishName(String englishName) throws DaoException;

    public void updateById(int id, String cityenglish, String citychinese) throws  DaoException;

}
