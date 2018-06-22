package com.madecare.springcloud.finchley.provide.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xuyangyang
 * @Description: TestController
 * @Date: 2018/6/21 16:35
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("")
    public String test(HttpServletRequest request){
        System.out.println(request.getHeader("test"));
        return "hello world!";
    }
}
