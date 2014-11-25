package com.springapp.services;

import com.springapp.domain.Manager;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2014/8/7.
 */

public interface ManagerService {

    public void saveManager(Manager manager) throws ServiceException, DaoException;

    public void updateManager(Manager manager) throws ServiceException, DaoException;

    public Manager findByNameAndPwd(String name, String pwd) throws DaoException;

    public Manager findByName(String name) throws DaoException;

    public List<Manager> findAllManager(String hql) throws DaoException;

    public boolean deleteByName(String name) throws DaoException;

}
