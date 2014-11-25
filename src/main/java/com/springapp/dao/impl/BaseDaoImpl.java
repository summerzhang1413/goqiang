package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.domain.BaseDomain;
import com.springapp.exception.DaoException;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("baseDaoImpl")
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

    @Resource(name="sessionFactory")
    public void setMySessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void save(BaseDomain obj) throws DaoException {
        getHibernateTemplate().save(obj);
    }

    @Override
    public void delete(BaseDomain obj) throws DaoException {
        getHibernateTemplate().delete(obj);
    }

    @Override
    public void update(BaseDomain obj) throws DaoException {
        getHibernateTemplate().update(obj);
    }

    @Override
    public List find(String queryString) throws DaoException {
        return getHibernateTemplate().find(queryString);
    }

    @Override
    public List find(String queryString, Object param) throws DaoException {
        return getHibernateTemplate().find(queryString, param);
    }

}
