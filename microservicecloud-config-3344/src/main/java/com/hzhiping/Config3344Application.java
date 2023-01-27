package com.hzhiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author hzhiping
 * @date 2023/01/26
 */
@SpringBootApplication
@EnableConfigServer
public class Config3344Application {
    public static void main(String[] args) {
        SpringApplication.run(Config3344Application.class);
    }
}