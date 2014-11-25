package com.springapp.services;

import com.springapp.domain.UsersWin;
import com.springapp.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2014/8/31.
 */
public interface UsersWinService {

    public List<UsersWin> findByName(String username) throws DaoException;

    public List<UsersWin> findByTel(String tel) throws DaoException;

    public List<UsersWin> findByHqlString(String hql) throws DaoException;

    public void update(UsersWin usersWin) throws DaoException;

    public void save(UsersWin usersWin) throws DaoException;
}
