package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.CityDao;
import com.springapp.domain.City;
import com.springapp.exception.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2014/8/6.
 */
@Transactional
@Repository("cityDaoImpl")
public class CityDaoImpl implements CityDao {

    @Autowired
    public BaseDao baseDao;

    public SessionFactory sessionFactory;

    @Resource(name="sessionFactory")
    private void setSessionFactory(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


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
        List<City> listAllCity = baseDao.find(hql);
        return listAllCity;
    }

    @Override
    public List<City> findCityByCityEnglish(String hql) throws DaoException {
        List<City> listAllCity = baseDao.find(hql);
        return listAllCity;
    }

    @Override
    public int findIdByEnglishName(String englishName) throws DaoException {
        String hql = "from City c where c.cityenglish=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, englishName);
        List<City> listCity = query.list();

        return listCity.get(0).getId();
    }

    @Override
    public void updateById(int id, String cityenglish, String citychinese) throws DaoException {

    }
}
