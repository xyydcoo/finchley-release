package com.madecare.springcloud.finchley.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
//标准的spring cloud独立于体系之外，eureka也可以去config读取配置信息
//@EnableDiscoveryClient
public class FinchleyConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinchleyConfigApplication.class, args);
    }
}
