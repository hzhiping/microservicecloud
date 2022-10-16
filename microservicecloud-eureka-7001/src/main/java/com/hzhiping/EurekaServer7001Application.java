package com.hzhiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用@EnableEurekaServer注解标签表示这个类是EurekaServer服务器启动类，接受其他微服务注册进来
 *
 * @author hzhiping
 * @date 2022/09/02
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001Application {
    /**
     * 函数入口
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001Application.class, args);
    }
}