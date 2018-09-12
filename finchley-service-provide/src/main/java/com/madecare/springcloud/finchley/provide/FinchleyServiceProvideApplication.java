package com.madecare.springcloud.finchley.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableAsync
public class FinchleyServiceProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinchleyServiceProvideApplication.class, args);
    }
}
