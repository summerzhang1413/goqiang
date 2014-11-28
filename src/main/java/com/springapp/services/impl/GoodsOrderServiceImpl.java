package com.springapp.services.impl;

import com.springapp.dao.GoodsOrderDao;
import com.springapp.domain.GoodsOrder;
import com.springapp.exception.DaoException;
import com.springapp.services.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/11/28.
 */
@Service("goodsOrderServiceImpl")
public class GoodsOrderServiceImpl implements GoodsOrderService {
    @Autowired
    private GoodsOrderDao goodsOrderDao;
    @Override
    public List<GoodsOrder> findByName(String username) throws DaoException {
        return goodsOrderDao.findByName(username);
    }
}
