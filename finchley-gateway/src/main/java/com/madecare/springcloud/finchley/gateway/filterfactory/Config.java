package com.madecare.springcloud.finchley.gateway.filterfactory;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xuyangyang
 * @Description: Config
 * @Date: 2018/6/21 16:18
 */
@Configuration
public class Config {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r->r.path("/test/**").filters(f->f.hystrix(config -> config.setFallbackUri("forward:/fallback").setName("fallbackcmd")).retry(3).filter(new PreGatewayFilterFactory().apply()).stripPrefix(1)).uri("lb://user"))
                .build();
    }
}
