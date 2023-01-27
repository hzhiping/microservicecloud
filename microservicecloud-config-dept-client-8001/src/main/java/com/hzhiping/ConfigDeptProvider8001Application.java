package com.hzhiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hzhiping
 * @date 2023/01/27
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ConfigDeptProvider8001Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigDeptProvider8001Application.class, args);
    }
}