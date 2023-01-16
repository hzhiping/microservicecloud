package com.hzhiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author hzhiping
 * @date 2023/01/16
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.hzhiping"})
public class LongLink8777Application {
    public static void main(String[] args) {
        SpringApplication.run(LongLink8777Application.class, args);
    }
}