package com.springapp.services;

import com.springapp.domain.GoodsInfo;
import com.springapp.domain.GoodsSubmit;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2014/9/1.
 */
public interface GoodsSubmitService {

    public void save(GoodsSubmit goodsSubmit) throws DaoException, ServiceException;

    public GoodsSubmit findLastByUsername(String username) throws DaoException, ServiceException;

    public int getSubmitNumByTodayDateAndUsername(String todayDate, String username) throws DaoException, ServiceException;

    public List<GoodsInfo> findByHqlString(String hql) throws DaoException, ServiceException;
}
