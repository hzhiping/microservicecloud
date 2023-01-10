package com.hzhiping.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author hzhiping
 * @date 2023/01/10
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.hzhiping"})
public class DeptConsumerForeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerForeignApplication.class, args);
    }
}