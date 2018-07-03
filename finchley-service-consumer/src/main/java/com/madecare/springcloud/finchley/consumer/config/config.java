package com.madecare.springcloud.finchley.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xuyangyang
 * @Description: config
 * @Date: 2018/7/3 9:14
 */
@Configuration
public class config {

    @Bean(name = "fallbackRestTemplate")
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
