package com.seu.edu.bd.hrmserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class HrmServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmServerApplication.class, args);
    }

}
