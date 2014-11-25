package com.springapp.services.impl;

import com.springapp.dao.UserDao;
import com.springapp.dao.impl.BaseDaoImpl;
import com.springapp.domain.User;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/8/31.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;
    @Autowired
    public BaseDaoImpl baseDaoImpl;

    @Override
    public void save(User user) throws DaoException {
        baseDaoImpl.save(user);
    }

    @Override
    public User findByNameAndPwd(String username, String pwd) throws DaoException {
        return userDao.findByNameAndPwd(username, pwd);
    }

    @Override
    public User findByTelAndPwd(String tel, String pwd) throws DaoException {
        return userDao.findByTelAndPwd(tel, pwd);
    }

    @Override
    public User findByName(String username) throws DaoException {
        return userDao.findByName(username);
    }

    @Override
    public User findByTel(String tel) throws DaoException {
        return userDao.findByTel(tel);
    }

    @Override
    public User findByNameAndTel(String name, String tel) throws DaoException {
        return userDao.findByNameAndTel(name, tel);
    }

    @Override
    public void updateGradeByName(int grade, String username) throws DaoException {
        userDao.updateGradeByName(grade, username);
    }

    @Override
    public void updateGradeByTel(int grade, String tel) throws DaoException {
        userDao.updateGradeByTel(grade, tel);
    }

    @Override
    public void updateUsernameByTel(String username, String tel) throws DaoException {
        userDao.updateUsernameByTel(username, tel);
    }

    @Override
    public void updateTelByUsername(String tel, String username) throws DaoException {
        userDao.updateTelByUsername(tel, username);
    }

    @Override
    public void updatePwdByUsername(String pwd, String username) throws DaoException {
        userDao.updatePwdByUsername(pwd, username);
    }

    @Override
    public void updateAddressByUsername(String address, String username) throws DaoException {
        userDao.updateAddressByUsername(address, username);
    }

    @Override
    public List<User> findByHqlString(String hql) throws DaoException, ServiceException {
        return userDao.findByHqlString(hql);
    }
}
