package com.hzhiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author hzhiping
 * @date 2023/01/22
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptHystrixConsumerDashboard {
    public static void main(String[] args) {
        SpringApplication.run(DeptHystrixConsumerDashboard.class);
    }
}