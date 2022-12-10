package com.hzhiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hzhiping
 * @date 2022/08/13
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8003Application {
    /**
     * 客户端主函数入口
     *
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003Application.class, args);
    }
}