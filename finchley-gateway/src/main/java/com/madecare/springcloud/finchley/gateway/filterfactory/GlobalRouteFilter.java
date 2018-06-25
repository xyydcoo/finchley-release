package com.madecare.springcloud.finchley.gateway.filterfactory;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: xuyangyang
 * @Description: GlobalRouteFilter
 * @Date: 2018/6/22 13:17
 */
@Configuration
public class GlobalRouteFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
        builder.header("GlobalFilter","GlobalFilter success");
        chain.filter(exchange.mutate().request(builder.build()).build());
        return chain.filter(exchange.mutate().request(builder.build()).build());
    }
}
