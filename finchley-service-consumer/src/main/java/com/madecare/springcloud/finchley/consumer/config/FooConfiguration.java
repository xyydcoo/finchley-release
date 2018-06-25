package com.madecare.springcloud.finchley.consumer.config;

import com.madecare.springcloud.finchley.consumer.interceptor.BasicHeaderRequestInterceptor;
import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Author: xuyangyang
 * @Description: FooConfiguration
 * @Date: 2018/6/25 13:59
 */
public class FooConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public BasicHeaderRequestInterceptor basicHeaderRequestInterceptor() {
        return new BasicHeaderRequestInterceptor("interceptor", "BasicHeaderRequestInterceptor");
    }



}
