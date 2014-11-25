package com.springapp.services;

import com.springapp.domain.GoodsInfo;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2014/9/1.
 */
public interface GoodsInfoService {

    public void updateGoodsInfo(String imagename, String goodsname,
           String price, String number, String detail, String datefinal, String city) throws DaoException,ServiceException;
    public List<GoodsInfo> findAllGoodsInfo(String hql) throws DaoException, ServiceException;

    public GoodsInfo findByImageName(String imagename) throws DaoException, ServiceException;

    public void insertGoodsInfo(GoodsInfo goodsInfo) throws ServiceException;

    public int getRecommendNum(String hql) throws DaoException;

}
