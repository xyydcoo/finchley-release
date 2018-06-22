package com.madecare.springcloud.finchley.gateway.route;

import com.madecare.springcloud.finchley.gateway.filterfactory.GlobalRouteFilter;
import com.madecare.springcloud.finchley.gateway.filterfactory.PostGatewayFilterFactory;
import com.madecare.springcloud.finchley.gateway.filterfactory.PreGatewayFilterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xuyangyang
 * @Description: Config
 * @Date: 2018/6/21 16:18
 */
@Configuration
public class RoutesConfig {

    @Autowired
    private KeyResolver addressKeyResolver;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/test/**").filters(f -> f.retry(3).filter(new PreGatewayFilterFactory().apply()).filter(new PostGatewayFilterFactory().apply()).requestRateLimiter().rateLimiter(RedisRateLimiter.class,config -> config.setBurstCapacity(1).setReplenishRate(1)).configure(config -> config.setKeyResolver(addressKeyResolver)).stripPrefix(1).hystrix(config -> config.setFallbackUri("forward:/fallback").setName("fallbackcmd"))).uri("lb://user"))
                .build();
    }

    @Bean
    public GlobalRouteFilter globalRouteFilter() {
        return new GlobalRouteFilter();
    }
}