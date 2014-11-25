package com.springapp.services;

import com.springapp.domain.Notice;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;

import java.util.List;

public interface NoticeService {

    public void insert(Notice notice) throws DaoException, ServiceException;

    public void delete(int id) throws DaoException, ServiceException;

    public void update(Notice notice) throws DaoException, ServiceException;

    public List<Notice> findAllNotice(String hql) throws DaoException, ServiceException;

}
