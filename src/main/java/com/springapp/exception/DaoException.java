package com.springapp.exception;

/**
 * Created by Administrator on 2014/8/6.
 */
public class DaoException extends Exception {

    public DaoException(){
        super("无法与数据库交互，请与管理员联系！");
    }

    public DaoException(String string){
        super(string);
    }

}
