package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hzhiping
 * @date 2023/01/18
 */
@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker//对hystrix熔断机制的支持
public class DeptProviderHystrix8001Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001Application.class);
    }
}