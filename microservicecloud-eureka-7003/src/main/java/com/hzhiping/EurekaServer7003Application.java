package com.hzhiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hzhiping
 * @date 2022/09/02
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003Application.class, args);
    }
}