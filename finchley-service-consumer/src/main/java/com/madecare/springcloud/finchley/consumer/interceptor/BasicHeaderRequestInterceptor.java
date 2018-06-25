package com.madecare.springcloud.finchley.consumer.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @Author: xuyangyang
 * @Description: BasicHeaderRequestInterceptor
 * @Date: 2018/6/25 14:35
 */
public class BasicHeaderRequestInterceptor implements RequestInterceptor {

    private final String name;

    private final String value;

    @Override
    public void apply(RequestTemplate template) {
        template.header(name,value);
    }

    public BasicHeaderRequestInterceptor(String name,String value){
        this.name=name;
        this.value = value;
    }

}
