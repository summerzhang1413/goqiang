package com.springapp.dao;

import com.springapp.domain.OpenWin;
import com.springapp.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2014/8/31.
 */
public interface OpenWinDao {

    public List<OpenWin> findByHqlString(String hql) throws DaoException;

    public List<OpenWin> findByDateFinal(String datefinal) throws DaoException;

    public boolean deleteById(String id) throws DaoException;

}
