package com.springapp.services;

import com.springapp.domain.Suggestion;
import com.springapp.exception.DaoException;
import com.springapp.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2014/9/1.
 */
public interface SuggestionService {

    public void save(Suggestion suggestion) throws DaoException, ServiceException;

    public void delete(Suggestion suggestion) throws DaoException, ServiceException;

    public List<Suggestion> find(String hql) throws DaoException, ServiceException;

    public boolean deleteById(String id) throws DaoException;
}
