package com.madecare.springcloud.finchley.consumer.Rest;

import com.madecare.springcloud.finchley.consumer.feignclient.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xuyangyang
 * @Description: TestController
 * @Date: 2018/6/25 15:45
 */
@RestController
public class TestController {

    private final UserClient userClient;

    @GetMapping("/test")
    public String test(@RequestParam("flag") int flag) {
        return userClient.feignTest(flag);
    }

    @Autowired
    public TestController(UserClient userClient) {
        this.userClient = userClient;
    }
}
