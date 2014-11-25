package com.springapp.services;

import com.springapp.domain.User;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2014/8/31.
 */
public interface UserService {

    public void save(User user) throws DaoException;

    public User findByNameAndPwd(String username, String pwd) throws DaoException;

    public User findByTelAndPwd(String tel, String pwd) throws DaoException;

    public User findByName(String username) throws DaoException;

    public User findByTel(String tel) throws DaoException;

    public User findByNameAndTel(String name, String tel) throws DaoException;

    public void updateGradeByName(int grade, String username) throws DaoException;

    public void updateGradeByTel(int grade, String tel) throws DaoException;

    public void updateUsernameByTel(String username, String tel) throws DaoException;

    public void updateTelByUsername(String tel, String username) throws DaoException;

    public void updatePwdByUsername(String pwd, String username) throws DaoException;

    public void updateAddressByUsername(String address, String username) throws DaoException;

    public List<User> findByHqlString(String hql) throws DaoException, ServiceException;
}
