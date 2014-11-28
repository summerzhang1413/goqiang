package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.GoodsOrderDao;
import com.springapp.domain.GoodsOrder;
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
 * Created by Administrator on 2014/11/28.
 */
@Transactional
@Repository("goodsOrderDaoImpl")
public class GoodsOrderDaoImpl implements GoodsOrderDao{
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
    public List<GoodsOrder> findByName(String username) throws DaoException {
        String hql = "from GoodsOrder g where g.username = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, username);
        List<GoodsOrder> goodsOrderList = query.list();
        if(goodsOrderList == null || goodsOrderList.size() == 0){
            return null;
        }
        return goodsOrderList;
    }
}
