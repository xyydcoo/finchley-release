package com.madecare.springcloud.finchley.provide.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private int port;

    @RequestMapping("/weight")
    public String weight(){
        logger.info("handle the request's port："+port );
        return "hello world!";
    }

    @RequestMapping("")
    public String test(HttpServletRequest request){
        logger.info(request.getHeader("GatewayFilter"));
        logger.info(request.getHeader("GlobalFilter"));
        return "hello world!";
    }
}
