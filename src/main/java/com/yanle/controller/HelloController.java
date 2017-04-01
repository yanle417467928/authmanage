package com.yanle.controller;

import com.yanle.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页欢迎Controller
 *
 * @author yanle
 * @create 2017-02-13 10:34
 **/
@Controller
public class HelloController {



    @RequestMapping("/hello")
    public String sayHello() throws Exception {
        System.out.print("进入方法");
        throw new MyException("错误发生");
    }
}
