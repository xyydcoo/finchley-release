package com.madecare.springcloud.finchley.gateway.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuyangyang
 * @Description: CommonFallbackController
 * @Date: 2018/6/21 14:42
 */
@RestController
@RequestMapping("/fallback")
public class CommonFallbackController {

    @RequestMapping("")
    public String fallback(){
        return "fallback";
    }
}

