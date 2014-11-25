package com.springapp.dao;

import com.springapp.domain.BaseDomain;
import com.springapp.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2014/8/6.
 */
public interface BaseDao {

    public void save(BaseDomain obj) throws DaoException;

    public void delete(BaseDomain obj) throws DaoException;

    public void update(BaseDomain obj) throws DaoException;
    //@param queryString 查询数据的hql语句
    public List find(String queryString) throws DaoException;
    //根据传入的参数param进行hql查询
    public List find(String queryString, Object param) throws DaoException;

}
