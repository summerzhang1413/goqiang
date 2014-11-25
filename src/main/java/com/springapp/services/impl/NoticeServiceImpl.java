package com.springapp.services.impl;

import com.springapp.dao.BaseDao;
import com.springapp.domain.Notice;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/8/7.
 */
@Service("noticeServiceImpl")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    BaseDao baseDao;
    @Override
    public void insert(Notice notice) throws DaoException, ServiceException {
        baseDao.save(notice);
    }

    @Override
    public void delete(int id) throws DaoException, ServiceException {

    }

    @Override
    public void update(Notice notice) throws DaoException, ServiceException {
        baseDao.update(notice);
    }

    @Override
    public List<Notice> findAllNotice(String hql) throws DaoException, ServiceException {
        List<Notice> noticeList = baseDao.find(hql);
        return noticeList;
    }
}
