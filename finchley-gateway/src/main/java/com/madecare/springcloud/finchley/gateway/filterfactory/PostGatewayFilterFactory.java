package com.madecare.springcloud.finchley.gateway.filterfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

/**
 * @Author: xuyangyang
 * @Description: PostGatewayFilterFactory
 * @Date: 2018/6/21 16:15
 */
public class PostGatewayFilterFactory extends AbstractGatewayFilterFactory<PostGatewayFilterFactory.Config> {

    private Logger logger = LoggerFactory.getLogger(PostGatewayFilterFactory.class);

    public PostGatewayFilterFactory() {
        super(Config.class);
    }

    public GatewayFilter apply() {
        return apply(o -> {
        });
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            logger.info("PostGatewayFilter...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                //Manipulate the response in some way
            }));
        };
    }
    public static class Config {
        //Put the configuration properties for your filter here
    }
}
