package com.madecare.springcloud.finchley.redis;

import com.madecare.springcloud.finchley.redis.config.MCloudClusterConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({MCloudClusterConfigurationProperties.class})
public class FinchleyRedisStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinchleyRedisStarterApplication.class, args);
    }
}
