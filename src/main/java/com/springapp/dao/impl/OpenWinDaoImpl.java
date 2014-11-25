package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.OpenWinDao;
import com.springapp.domain.OpenWin;
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
 * Created by Administrator on 2014/8/31.
 */
@Transactional
@Repository("openWinDaoImpl")
public class OpenWinDaoImpl implements OpenWinDao {

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
    public List<OpenWin> findByHqlString(String hql) throws DaoException {
        List<OpenWin> openWinList = baseDao.find(hql);
        return openWinList;
    }

    @Override
    public List<OpenWin> findByDateFinal(String datefinal) throws DaoException {
        String hql = "from OpenWin o where o.datefinal=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, datefinal);
        List<OpenWin> openWin_list = query.list();
        if(openWin_list == null || openWin_list.size() == 0){
            return null;
        }
        return openWin_list;
    }

    @Override
    public boolean deleteById(String id) throws DaoException {
        String hql = "delete OpenWin o where o.id=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, Integer.parseInt(id));
        query.executeUpdate();
        return true;
    }
}
