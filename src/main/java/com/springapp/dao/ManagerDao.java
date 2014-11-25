package com.springapp.dao;

import com.springapp.domain.Manager;
import com.springapp.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2014/8/6.
 */
public interface ManagerDao {

    public void save(Manager obj) throws DaoException;

    public void delete(Manager obj) throws DaoException;

    public void update(Manager obj) throws DaoException;

    public Manager findByNameAndPwd(String name, String pwd) throws DaoException;

    public Manager findByName(String name) throws DaoException;

    public List<Manager> findAllManager(String hql) throws DaoException;

    public boolean deleteByName(String hql) throws DaoException;
}
