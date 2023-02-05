package com.coldeye.coldeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ColdEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColdEurekaApplication.class, args);
    }

}
