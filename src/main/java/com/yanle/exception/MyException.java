package com.yanle.exception;

/**
 * 自定义异常
 *
 * @author yanle
 * @create 2017-02-13 14:09
 **/
public class MyException extends Exception {
    public MyException(String message){
        super(message);
    }
}
