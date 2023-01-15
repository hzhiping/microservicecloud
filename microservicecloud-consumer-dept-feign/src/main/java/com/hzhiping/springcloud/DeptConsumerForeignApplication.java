package com.hzhiping.springcloud;

import feign.Contract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.context.request.RequestContextListener;

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

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}