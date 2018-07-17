package com.madecare.springcloud.finchley.redis.config;

import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;


/**
 * @Author: xuyangyang
 * @Description: TODO
 * @Date: 2018/7/10 8:51
 */
@Configuration
@ConditionalOnClass(RedisClient.class)
public class MCloudRedisAutoConfiguration {

    @Autowired
    private MCloudClusterConfigurationProperties configurationProperties;

    @Bean
    public LettuceConnectionFactory commonRedisLettuceConnectionFactory() {
        return new LettuceConnectionFactory(new RedisClusterConfiguration(configurationProperties.getNodes()));
    }

    @Bean
    ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        return new ReactiveRedisTemplate<>(factory, RedisSerializationContext.string());
    }

}
