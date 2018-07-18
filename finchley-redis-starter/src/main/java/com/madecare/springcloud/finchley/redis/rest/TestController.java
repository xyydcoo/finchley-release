package com.madecare.springcloud.finchley.redis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuyangyang
 * @Description: TODO
 * @Date: 2018/7/17 14:25
 */
@RestController
public class TestController {

    private final StringRedisTemplate redisTemplate;

    private volatile int testIndex = 0;

    @Autowired
    public TestController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/write")
    public Boolean write() {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            String key = "Spring Boot 2.0 Test";
            String value = String.valueOf(testIndex++);
            return connection.set(key.getBytes(), value.getBytes());

        });
    }


}
