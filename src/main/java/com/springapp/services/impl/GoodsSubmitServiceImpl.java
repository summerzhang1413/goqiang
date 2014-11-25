package com.springapp.services.impl;

import com.springapp.dao.GoodsSubmitDao;
import com.springapp.dao.impl.BaseDaoImpl;
import com.springapp.domain.GoodsInfo;
import com.springapp.domain.GoodsSubmit;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.GoodsSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/9/1.
 */
@Service("goodsSubmitServiceImpl")
public class GoodsSubmitServiceImpl implements GoodsSubmitService{
    @Autowired
    BaseDaoImpl baseDaoImpl;
    @Autowired
    GoodsSubmitDao goodsSubmitDao;
    @Override
    public void save(GoodsSubmit goodsSubmit) throws DaoException, ServiceException {
        baseDaoImpl.save(goodsSubmit);
    }

    @Override
    public GoodsSubmit findLastByUsername(String username) throws DaoException, ServiceException {
        return goodsSubmitDao.findLastByUsername(username);
    }

    @Override
    public int getSubmitNumByTodayDateAndUsername(String todayDate, String username) throws DaoException, ServiceException {
        return goodsSubmitDao.getSubmitNumByTodayDateAndUsername(todayDate, username);
    }

    @Override
    public List<GoodsInfo> findByHqlString(String hql) throws DaoException, ServiceException {
        return goodsSubmitDao.findByHqlString(hql);
    }
}
