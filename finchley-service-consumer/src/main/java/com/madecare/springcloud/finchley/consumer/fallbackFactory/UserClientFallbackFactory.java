package com.madecare.springcloud.finchley.consumer.fallbackFactory;

import com.madecare.springcloud.finchley.consumer.feignclient.UserClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xuyangyang
 * @Description: UserClientfallbackFactory
 * @Date: 2018/6/25 15:25
 */
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    private static Logger logger = LoggerFactory.getLogger(UserClientFallbackFactory.class);

    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public String feignTest(int flag) {
                return null;
            }
        };
    }
}