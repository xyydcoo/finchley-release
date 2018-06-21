package com.madecare.springcloud.finchley.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinchleyServiceProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinchleyServiceProvideApplication.class, args);
    }
}
