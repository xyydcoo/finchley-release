package com.madecare.springcloud.finchley.provide.rest;

import com.madecare.springcloud.finchley.provide.test.Config;
import com.madecare.springcloud.finchley.provide.test.Dno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Executors;

/**
 * @Author: xuyangyang
 * @Description: TestController
 * @Date: 2018/6/21 16:35
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private Config config;

    @Value("${server.port}")
    private int port;

    @RequestMapping("/weight")
    public String weightTest(){
        logger.info("handle the request's port："+port );
        return "hello world!";
    }

    @RequestMapping("")
    public String filterTest(HttpServletRequest request){
        logger.info(request.getHeader("GatewayFilter"));
        logger.info(request.getHeader("GlobalFilter"));
        return "hello world!";
    }

    @GetMapping("/feign")
    public String feignTest(HttpServletRequest request, @RequestParam("flag") int flag){
        logger.info(request.getHeader("interceptor"));
       if(flag>5){
           return "feign call success!";
       }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "feign call success!";
    }

    @GetMapping("/fallbackRetry")
    public String fallbackRetry(HttpServletRequest request){
        return "fallbackRetry!";
    }

    @GetMapping("/bean")
    public String bean(){
        Dno dno = null;
        dno = config.getDno();
        dno.setTest();
        dno.type =1;
        dno.init();
        return "hello world";
    }
}
