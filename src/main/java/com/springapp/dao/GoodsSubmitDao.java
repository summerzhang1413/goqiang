package com.springapp.dao;

import com.springapp.domain.GoodsInfo;
import com.springapp.domain.GoodsSubmit;
import com.springapp.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2014/9/17.
 */
public interface GoodsSubmitDao {

    public GoodsSubmit findLastByUsername(String username) throws DaoException;

    public int getSubmitNumByTodayDateAndUsername(String todayDate, String username) throws DaoException;

    public List<GoodsInfo> findByHqlString(String hql) throws DaoException;
}
