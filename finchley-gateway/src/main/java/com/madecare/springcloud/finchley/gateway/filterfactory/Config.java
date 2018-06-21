package com.madecare.springcloud.finchley.gateway.filterfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xuyangyang
 * @Description: Config
 * @Date: 2018/6/21 16:18
 */
@Configuration
public class Config {
    @Bean
    public PreGatewayFilterFactory preGatewayFilterFactory(){
        return new PreGatewayFilterFactory();
    }

    @Bean
    public PostGatewayFilterFactory postGatewayFilterFactory(){
        return new PostGatewayFilterFactory();
    }
}
