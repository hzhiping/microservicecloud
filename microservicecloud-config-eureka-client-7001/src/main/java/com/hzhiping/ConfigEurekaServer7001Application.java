package com.hzhiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hzhiping
 * @date 2023/01/27
 */
@SpringBootApplication
@EnableEurekaServer
public class ConfigEurekaServer7001Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaServer7001Application.class, args);
    }
}