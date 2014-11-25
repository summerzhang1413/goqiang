package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.GoodsSubmitDao;
import com.springapp.domain.GoodsInfo;
import com.springapp.domain.GoodsSubmit;
import com.springapp.exception.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2014/9/17.
 */
@Transactional
@Repository("goodsSubmitDaoImpl")
public class GoodsSubmitDaoImpl implements GoodsSubmitDao {
    @Autowired
    public BaseDao baseDao;

    public SessionFactory sessionFactory;

    @Resource(name="sessionFactory")
    private void setSessionFactory(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public GoodsSubmit findLastByUsername(String username) throws DaoException {
        String hql = "from GoodsSubmit g where g.username=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, username);
        List<GoodsSubmit> goodsSubmits_list = query.list();
        if (goodsSubmits_list == null || goodsSubmits_list.size() == 0) {
            return null;
        }
        return goodsSubmits_list.get(goodsSubmits_list.size() - 1);
    }

    @Override
    public int getSubmitNumByTodayDateAndUsername(String todayDate, String username) throws DaoException {
        String hql = "from GoodsSubmit g where g.datesubmit=? and g.username=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, todayDate);
        query.setParameter(1, username);
        List<GoodsSubmit> goodsSubmits_list = query.list();
        if (goodsSubmits_list == null || goodsSubmits_list.size() == 0) {
            return 0;
        }
        return goodsSubmits_list.size();
    }

    @Override
    public List<GoodsInfo> findByHqlString(String hql) throws DaoException {
        List<GoodsInfo> goodsInfoList = baseDao.find(hql);
        return goodsInfoList;
    }


}
