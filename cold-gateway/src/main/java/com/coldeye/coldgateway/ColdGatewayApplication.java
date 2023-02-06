package com.coldeye.coldgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ColdGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColdGatewayApplication.class, args);
    }

}
