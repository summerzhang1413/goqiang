package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.UserDao;
import com.springapp.domain.User;
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
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

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
    public User findByNameAndPwd(String username, String pwd) throws DaoException {
        String hql = "from User u where u.name = ? and u.pwd = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, username);
        query.setParameter(1, pwd);
        List<User> user_list = query.list();
        if(user_list == null || user_list.size() == 0){
            return null;
        }
        return user_list.get(0);
    }

    @Override
    public User findByTelAndPwd(String tel, String pwd) throws DaoException {
        String hql = "from User u where u.tel = ? and u.pwd = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, tel);
        query.setParameter(1, pwd);
        List<User> user_list = query.list();
        if(user_list == null || user_list.size() == 0){
            return null;
        }
        return user_list.get(0);
    }

    @Override
    public User findByName(String username) throws DaoException {
        String hql = "from User u where u.name = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, username);
        List<User> user_list = query.list();
        if(user_list == null || user_list.size() == 0){
            return null;
        }
        return user_list.get(0);
    }

    @Override
    public User findByTel(String tel) throws DaoException {
        String hql = "from User u where u.tel = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, tel);
        List<User> user_list = query.list();
        if(user_list == null || user_list.size() == 0){
            return null;
        }
        return user_list.get(0);
    }

    @Override
    public User findByNameAndTel(String name, String tel) throws DaoException {
        String hql = "from User u where u.name = ? and u.tel = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, name);
        query.setParameter(1, tel);
        List<User> user_list = query.list();
        if(user_list == null || user_list.size() == 0){
            return null;
        }
        return user_list.get(0);
    }

    @Override
    public void updateGradeByName(int grade, String username) throws DaoException {
        String hql = "update User u set u.grade=? where u.name=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, grade);
        query.setParameter(1, username);
        query.executeUpdate();
    }

    @Override
    public void updateGradeByTel(int grade, String tel) throws DaoException {
        String hql = "update User u set u.grade=? where u.tel=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, grade);
        query.setParameter(1, tel);
        query.executeUpdate();
    }

    @Override
    public void updateUsernameByTel(String username, String tel) throws DaoException {
        String hql = "update User u set u.name=? where u.tel=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, username);
        query.setParameter(1, tel);
        query.executeUpdate();
    }

    @Override
    public void updateTelByUsername(String tel, String username) throws DaoException {
        String hql = "update User u set u.tel=? where u.name=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, tel);
        query.setParameter(1, username);
        query.executeUpdate();
    }

    @Override
    public void updatePwdByUsername(String pwd, String username) throws DaoException {
        String hql = "update User u set u.pwd=? where u.name=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, pwd);
        query.setParameter(1, username);
        query.executeUpdate();
    }

    @Override
    public void updateAddressByUsername(String address, String username) throws DaoException {
        String hql = "update User u set u.address=? where u.name=? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, address);
        query.setParameter(1, username);
        query.executeUpdate();
    }

    @Override
    public List<User> findByHqlString(String hql) throws DaoException {
        List<User> userList = baseDao.find(hql);
        return userList;
    }
}
