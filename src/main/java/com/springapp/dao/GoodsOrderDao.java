package com.springapp.dao;

import com.springapp.domain.GoodsOrder;
import com.springapp.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2014/11/28.
 */
public interface GoodsOrderDao {

    public List<GoodsOrder> findByName(String username) throws DaoException;
}
