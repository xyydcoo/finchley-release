package com.madecare.springcloud.finchley.redis.config;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.JedisClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

/**
 * @Author: xuyangyang
 * @Description: MCloud Jedis Configuration
 * @Date: 2018/7/18 10:52
 */
@Configuration
@ConditionalOnClass({GenericObjectPool.class, JedisConnection.class, Jedis.class})
public class MCloudJedisConnectionConfiguration {

    private final MCloudClusterConfigurationProperties configurationProperties;

    private final List<JedisClientConfigurationBuilderCustomizer> builderCustomizers;

    MCloudJedisConnectionConfiguration(MCloudClusterConfigurationProperties configurationProperties,
                                       ObjectProvider<List<JedisClientConfigurationBuilderCustomizer>> builderCustomizers) {
        this.configurationProperties = configurationProperties;
        this.builderCustomizers = builderCustomizers
                .getIfAvailable(Collections::emptyList);
    }

    @Bean
    public RedisConnectionFactory connectionFactory() {
        JedisClientConfiguration clientConfiguration = getJedisClientConfiguration();
        return new JedisConnectionFactory(getClusterConfiguration(),
                clientConfiguration);
    }

    private RedisClusterConfiguration getClusterConfiguration() {
        RedisClusterConfiguration config = new RedisClusterConfiguration(
                configurationProperties.getCluster().getNodes());
        if (configurationProperties.getCluster().getMaxRedirects() != null) {
            config.setMaxRedirects(configurationProperties.getCluster().getMaxRedirects());
        }
        if (this.configurationProperties.getPassword() != null) {
            config.setPassword(RedisPassword.of(this.configurationProperties.getPassword()));
        }
        return config;
    }


    private JedisClientConfiguration getJedisClientConfiguration() {
        JedisClientConfiguration.JedisClientConfigurationBuilder builder = applyProperties(
                JedisClientConfiguration.builder());
        MCloudClusterConfigurationProperties.Pool pool = this.configurationProperties.getJedis().getPool();
        if (pool != null) {
            applyPooling(pool, builder);
        }
        customize(builder);
        return builder.build();
    }

    private JedisClientConfiguration.JedisClientConfigurationBuilder applyProperties(
            JedisClientConfiguration.JedisClientConfigurationBuilder builder) {
        if (this.configurationProperties.isSsl()) {
            builder.useSsl();
        }
        if (this.configurationProperties.getTimeout() != null) {
            Duration timeout = this.configurationProperties.getTimeout();
            builder.readTimeout(timeout).connectTimeout(timeout);
        }
        return builder;
    }

    private void customize(
            JedisClientConfiguration.JedisClientConfigurationBuilder builder) {
        for (JedisClientConfigurationBuilderCustomizer customizer : this.builderCustomizers) {
            customizer.customize(builder);
        }
    }

    private void applyPooling(MCloudClusterConfigurationProperties.Pool pool,
                              JedisClientConfiguration.JedisClientConfigurationBuilder builder) {
        builder.usePooling().poolConfig(jedisPoolConfig(pool));
    }

    private JedisPoolConfig jedisPoolConfig(MCloudClusterConfigurationProperties.Pool pool) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(pool.getMaxActive());
        config.setMaxIdle(pool.getMaxIdle());
        config.setMinIdle(pool.getMinIdle());
        if (pool.getMaxWait() != null) {
            config.setMaxWaitMillis(pool.getMaxWait().toMillis());
        }
        return config;
    }
}
