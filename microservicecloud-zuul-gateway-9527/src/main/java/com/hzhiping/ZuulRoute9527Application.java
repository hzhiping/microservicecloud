package com.hzhiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author hzhiping
 * @date 2023/01/23
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulRoute9527Application {
    public static void main(String[] args) {
        SpringApplication.run(ZuulRoute9527Application.class);
    }
}