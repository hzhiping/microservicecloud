package com.hzhiping.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hzhiping
 */
@SpringBootApplication
@EnableEurekaClient //开启Eureka服务发现
@EnableDiscoveryClient //启动服务发现
public class DeptConsumer80Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80Application.class, args);
    }
}