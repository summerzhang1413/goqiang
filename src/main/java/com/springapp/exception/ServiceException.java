package com.springapp.exception;

/**
 * Created by Administrator on 2014/8/7.
 */
public class ServiceException extends Exception{

    public ServiceException(){
        super();
    }

    public ServiceException(String string){
        super(string);
    }

}
