package com.madecare.springcloud.finchley.provide.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: xuyangyang
 * @Description: TODO
 * @Date: 2018/8/3 10:20
 */

class DnoObj{
    public volatile int type;
}

@Component
class Test{

}

public class Dno extends DnoObj{

    private static Logger logger = LoggerFactory.getLogger(Dno.class);

    @Autowired
    private Test test;

    @Async
    public void init(){
        logger.info("init");
        System.out.println(type);
    }

    @Async
    public void setTest(){
        logger.info("async");
        System.out.println("async"+type);
    }

}
