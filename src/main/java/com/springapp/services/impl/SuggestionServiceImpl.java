package com.springapp.services.impl;

import com.springapp.dao.BaseDao;
import com.springapp.dao.SuggestionDao;
import com.springapp.domain.Suggestion;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;
import com.springapp.services.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2014/9/1.
 */
@Service("suggestionServiceImpl")
public class SuggestionServiceImpl implements SuggestionService{
    @Autowired
    BaseDao baseDao;
    @Autowired
    SuggestionDao suggestionDao;
    @Override
    public void save(Suggestion suggestion) throws DaoException, ServiceException {
        baseDao.save(suggestion);
    }

    @Override
    public void delete(Suggestion suggestion) throws DaoException, ServiceException {
        baseDao.delete(suggestion);
    }

    @Override
    public List<Suggestion> find(String hql) throws DaoException, ServiceException {
        List<Suggestion> suggestionList = baseDao.find(hql);
        return suggestionList;
    }

    @Override
    public boolean deleteById(String id) throws DaoException {
        return suggestionDao.deleteById(id);
    }
}
