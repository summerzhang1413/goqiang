package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.ManagerDao;
import com.springapp.domain.Manager;
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
@Repository("managerDaoImpl")
public class ManagerDaoImpl implements ManagerDao {

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
    public void save(Manager obj) throws DaoException {
        baseDao.save(obj);
    }

    @Override
    public void delete(Manager obj) throws DaoException {
        baseDao.delete(obj);
    }

    @Override
    public void update(Manager obj) throws DaoException {
        baseDao.update(obj);
    }

    public List<Manager> findAllManager(String hql) throws DaoException {
        List<Manager> listManager = baseDao.find(hql);
        return listManager;
    }

    @Override
    public boolean deleteByName(String name) throws DaoException {
        String hql = "delete Manager where mName=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, name);
        query.executeUpdate();
        return true;
    }

    @Override
    public Manager findByNameAndPwd(String name, String pwd) throws DaoException {
        String hql = "from Manager m where m.mName=? and m.mPwd=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, name);
        query.setParameter(1, pwd);
        List<Manager> manager_list = query.list();
        if (manager_list == null || manager_list.size() == 0) {
            return null;
        }
        return manager_list.get(0);
    }

    @Override
    public Manager findByName(String name) throws DaoException {
        String hql = "from Manager where mName=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, name);
        List<Manager> managerList = query.list();
        if (managerList == null || managerList.size() == 0) {
            return null;
        }
        return managerList.get(0);
    }
}
