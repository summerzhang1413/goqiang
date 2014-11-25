package com.springapp.services;

import com.springapp.domain.OpenWin;
import com.springapp.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2014/8/31.
 */
public interface OpenWinService {

    public List<OpenWin> findByHqlString(String hql) throws DaoException;

    public List<OpenWin> findByDateFinal(String datefinal) throws DaoException;

    public void save(OpenWin openWin) throws DaoException;

    public void update(OpenWin openWin)  throws DaoException;

    public boolean deleteById(String id)  throws DaoException;
}
