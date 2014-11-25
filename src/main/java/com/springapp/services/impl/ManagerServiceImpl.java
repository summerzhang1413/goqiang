package com.springapp.services.impl;

import com.springapp.dao.ManagerDao;
import com.springapp.domain.Manager;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/8/7.
 */
@Service("managerServiceImpl")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    public ManagerDao managerDao;

    @Override
    public void saveManager(Manager manager) throws ServiceException, DaoException {
        managerDao.save(manager);
    }

    @Override
    public void updateManager(Manager manager) throws ServiceException, DaoException {
        managerDao.update(manager);
    }

    @Override
    public Manager findByNameAndPwd(String name, String pwd) throws DaoException {
        return managerDao.findByNameAndPwd(name, pwd);
    }

    @Override
    public Manager findByName(String name) throws DaoException {
        return managerDao.findByName(name);
    }

    @Override
    public List<Manager> findAllManager(String hql) throws DaoException {
        return managerDao.findAllManager(hql);
    }

    @Override
    public boolean deleteByName(String name) throws DaoException {
        return managerDao.deleteByName(name);
    }
}
