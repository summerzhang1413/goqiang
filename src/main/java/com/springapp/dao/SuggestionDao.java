package com.springapp.dao;

import com.springapp.domain.Suggestion;
import com.springapp.exception.DaoException;

/**
 * Created by Administrator on 2014/8/6.
 */
public interface SuggestionDao {

    public void delete(Suggestion obj) throws DaoException;

    public boolean deleteById(String id) throws DaoException;
}
