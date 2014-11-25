package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.GoodsInfoDao;
import com.springapp.domain.GoodsInfo;
import com.springapp.exception.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("goodsInfoDaoImpl")
public class GoodsInfoDaoImpl implements GoodsInfoDao {
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
    public void updateGoodsInfo(String imagename, String goodsname, String price, String number, String detail, String datefinal, String city) throws DaoException {
        String hql = "update GoodsInfo g set g.goodsname=?, g.price=?, g.number=?, g.detail=?, g.datefinal=?, g.city=? where g.imagename=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, goodsname);
        query.setParameter(1, price);
        query.setParameter(2, number);
        query.setParameter(3, detail);
        query.setParameter(4, datefinal);
        query.setParameter(5, city);
        query.setParameter(6, imagename);
        query.executeUpdate();
    }

    @Override
    public List<GoodsInfo> findAllGoodsInfo(String hql) throws DaoException {
        List<GoodsInfo> listGoodsInfo = baseDao.find(hql);
        return listGoodsInfo;
    }

    @Override
    public GoodsInfo findByImageName(String imagename) throws DaoException {
        String hql = "from GoodsInfo g where g.imagename=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, imagename);
        List<GoodsInfo> goodsInfos_list = query.list();
        if (goodsInfos_list == null || goodsInfos_list.size() == 0) {
            return null;
        }
        return goodsInfos_list.get(0);
    }

    @Override
    public void insertGoodsInfo(GoodsInfo goodsInfo) throws DaoException {
        baseDao.save(goodsInfo);
    }

    @Override
    public int getRecommendNum(String hql) throws DaoException {
        Query query = getSession().createQuery(hql);
        List list = query.list();
        return list.size();
    }
}
