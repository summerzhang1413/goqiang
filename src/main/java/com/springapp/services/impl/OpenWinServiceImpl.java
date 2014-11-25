package com.springapp.services.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.OpenWinDao;
import com.springapp.domain.OpenWin;
import com.springapp.exception.DaoException;
import com.springapp.services.OpenWinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/8/31.
 */
@Service("openWinServiceImpl")
public class OpenWinServiceImpl implements OpenWinService {
    @Autowired
    public OpenWinDao openWinDao;
    @Autowired
    public BaseDao baseDao;


    @Override
    public List<OpenWin> findByHqlString(String hql) throws DaoException {
        return openWinDao.findByHqlString(hql);
    }

    @Override
    public List<OpenWin> findByDateFinal(String datefinal) throws DaoException {
        return openWinDao.findByDateFinal(datefinal);
    }

    @Override
    public void save(OpenWin openWin) throws DaoException {
        baseDao.save(openWin);
    }

    @Override
    public void update(OpenWin openWin) throws DaoException {
        baseDao.update(openWin);
    }

    @Override
    public boolean deleteById(String id) throws DaoException {
        return openWinDao.deleteById(id);
    }
}
