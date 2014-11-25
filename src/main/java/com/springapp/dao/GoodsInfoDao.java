package com.springapp.dao;

import com.springapp.domain.GoodsInfo;
import com.springapp.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2014/9/17.
 */
public interface GoodsInfoDao {

    public void updateGoodsInfo(String imagename, String goodsname,
                                    String price, String number, String detail, String datefinal, String city) throws DaoException;
    public List<GoodsInfo> findAllGoodsInfo(String hql) throws DaoException;

    public GoodsInfo findByImageName(String imagename) throws DaoException;

    public void insertGoodsInfo(GoodsInfo goodsInfo) throws DaoException;

    public int getRecommendNum(String hql) throws DaoException;
}
