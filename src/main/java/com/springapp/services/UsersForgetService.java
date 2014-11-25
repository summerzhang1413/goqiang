package com.springapp.services;

import com.springapp.domain.UsersForget;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;

/**
 * Created by Administrator on 2014/9/1.
 */
public interface UsersForgetService {

    public void save(UsersForget usersForget) throws DaoException, ServiceException;
}
