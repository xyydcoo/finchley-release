package com.madecare.springcloud.finchley.redis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;

/**
 * @Author: xuyangyang
 * @Description: TODO
 * @Date: 2018/7/17 14:25
 */
@RestController
public class TestController {

    private final ReactiveRedisTemplate reactiveRedisTemplate;

    @Autowired
    public TestController(ReactiveRedisTemplate reactiveRedisTemplate) {
        this.reactiveRedisTemplate = reactiveRedisTemplate;
    }

    @GetMapping("/test")
    public Flux test() {
        Flux flux = reactiveRedisTemplate.execute(connection -> {
            RedisSerializationContext.SerializationPair stringSerializationPair = reactiveRedisTemplate.getSerializationContext().getStringSerializationPair();
            ByteBuffer key = stringSerializationPair.write(new String("Reactive-Redis"));
            ByteBuffer value = stringSerializationPair.write(new String("Spring data redis 2.0"));
            Mono<Boolean> set = connection.stringCommands().set(key, value);
            return set;
        });
        return flux;
    }

}
