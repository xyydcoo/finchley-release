package com.madecare.springcloud.finchley.consumer.feignclient;

import com.madecare.springcloud.finchley.consumer.config.FooConfiguration;
import com.madecare.springcloud.finchley.consumer.fallbackFactory.UserClientfallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: xuyangyang
 * @Description: UserClient
 * @Date: 2018/6/25 13:54
 */
@FeignClient(name = "user", configuration = FooConfiguration.class, fallbackFactory = UserClientfallbackFactory.class)
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/test/feign")
    String feignTest();
}
