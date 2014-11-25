package com.springapp.services.impl;

import com.springapp.dao.impl.BaseDaoImpl;
import com.springapp.domain.UsersForget;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.UsersForgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2014/9/1.
 */
@Service("usersForgetServiceImpl")
public class UsersForgetServiceImpl implements UsersForgetService {
    @Autowired
    BaseDaoImpl baseDaoImpl;

    @Override
    public void save(UsersForget usersForget) throws DaoException, ServiceException {
        baseDaoImpl.save(usersForget);
    }
}
