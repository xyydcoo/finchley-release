package com.madecare.springcloud.finchley.consumer.fallbackFactory;

import com.madecare.springcloud.finchley.consumer.feignclient.UserClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: xuyangyang
 * @Description: UserClientfallbackFactory
 * @Date: 2018/6/25 15:25
 */
@Component
public class UserClientfallbackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable throwable) {
        return () -> "feign fallback"+throwable.getMessage();
    }
}