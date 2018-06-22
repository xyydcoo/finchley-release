package com.madecare.springcloud.finchley.provide.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("")
    public String test(HttpServletRequest request){
        logger.info(request.getHeader("sign"));
        return "hello world!";
    }
}
