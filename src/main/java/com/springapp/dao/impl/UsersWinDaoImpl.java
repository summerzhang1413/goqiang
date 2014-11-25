package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.UsersWinDao;
import com.springapp.domain.UsersWin;
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
@Repository("usersWinDaoImpl")
public class UsersWinDaoImpl implements UsersWinDao {

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
    public List<UsersWin> findByName(String username) throws DaoException {
        String hql = "from UsersWin u where u.username = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, username);
        List<UsersWin> user_list = query.list();
        if(user_list == null || user_list.size() == 0){
            return null;
        }
        return user_list;
    }

    @Override
    public List<UsersWin> findByTel(String tel) throws DaoException {
        String hql = "from UsersWin u where u.usertel = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, tel);
        List<UsersWin> user_list = query.list();
        if(user_list == null || user_list.size() == 0){
            return null;
        }
        return user_list;
    }

    @Override
    public List<UsersWin> findByHqlString(String hql) throws DaoException {
        List<UsersWin> usersWinList = baseDao.find(hql);
        return usersWinList;
    }

    @Override
    public void update(UsersWin usersWin) throws DaoException {
        baseDao.update(usersWin);
    }

}
