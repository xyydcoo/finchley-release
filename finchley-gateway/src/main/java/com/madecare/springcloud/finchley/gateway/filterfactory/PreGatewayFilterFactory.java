package com.madecare.springcloud.finchley.gateway.filterfactory;


import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @Author: xuyangyang
 * @Description: PreGatewayFilterFactory
 * @Date: 2018/6/21 16:07
 */
public class PreGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange, chain) -> {
            System.out.println("PreGatewayFilterFactory");
            ServerHttpRequest request = exchange.getRequest().mutate()
                    .header("sign","gateway")
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        };
    }

}