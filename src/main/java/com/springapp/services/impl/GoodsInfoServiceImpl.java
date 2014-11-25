package com.springapp.services.impl;

import com.springapp.dao.GoodsInfoDao;
import com.springapp.dao.impl.BaseDaoImpl;
import com.springapp.domain.GoodsInfo;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/9/1.
 */
@Service("goodsInfoServiceImpl")
public class GoodsInfoServiceImpl implements GoodsInfoService {
    @Autowired
    BaseDaoImpl baseDaoImpl;
    @Autowired
    GoodsInfoDao goodsInfoDao;
    @Override
    public void updateGoodsInfo(String imagename, String goodsname, String price, String number, String detail, String datefinal, String city) throws DaoException,ServiceException {
        goodsInfoDao.updateGoodsInfo(imagename, goodsname, price, number, detail, datefinal, city);
    }

    @Override
    public List<GoodsInfo> findAllGoodsInfo(String hql) throws DaoException, ServiceException {
        return goodsInfoDao.findAllGoodsInfo(hql);
    }

    @Override
    public GoodsInfo findByImageName(String imagename) throws DaoException, ServiceException {
        return goodsInfoDao.findByImageName(imagename);
    }

    @Override
    public void insertGoodsInfo(GoodsInfo goodsInfo) throws ServiceException {
        try {
            goodsInfoDao.insertGoodsInfo(goodsInfo);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRecommendNum(String hql) throws DaoException {
        return goodsInfoDao.getRecommendNum(hql);
    }
}
