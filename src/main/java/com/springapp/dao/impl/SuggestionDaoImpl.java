package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.SuggestionDao;
import com.springapp.domain.Suggestion;
import com.springapp.exception.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2014/10/10.
 */
@Transactional
@Repository("suggestionDaoImpl")
public class SuggestionDaoImpl implements SuggestionDao {
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
    public void delete(Suggestion obj) throws DaoException {

    }
    @Override
    public boolean deleteById(String id) throws DaoException {
        String hql = "delete Suggestion s where s.id=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, Integer.parseInt(id));
        query.executeUpdate();
        return true;
    }
}
