package com.springapp.services.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.UsersWinDao;
import com.springapp.domain.UsersWin;
import com.springapp.exception.DaoException;
import com.springapp.services.UsersWinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/8/31.
 */
@Service("usersWinServiceImpl")
public class UsersWinServiceImpl implements UsersWinService {
    @Autowired
    public UsersWinDao usersWinDao;
    @Autowired
    public BaseDao baseDao;

    @Override
    public List<UsersWin> findByName(String username) throws DaoException {
        return usersWinDao.findByName(username);
    }

    @Override
    public List<UsersWin> findByTel(String tel) throws DaoException {
        return usersWinDao.findByTel(tel);
    }

    @Override
    public List<UsersWin> findByHqlString(String hql) throws DaoException {
        return usersWinDao.findByHqlString(hql);
    }

    @Override
    public void update(UsersWin usersWin) throws DaoException {
        usersWinDao.update(usersWin);
    }

    @Override
    public void save(UsersWin usersWin) throws DaoException {
        baseDao.save(usersWin);
    }
}
