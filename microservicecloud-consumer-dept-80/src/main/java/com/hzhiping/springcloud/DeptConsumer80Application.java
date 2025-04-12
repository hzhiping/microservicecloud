package com.hzhiping.springcloud;

import com.hzhiping.config.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author hzhiping
 * @date 2023/01/11
 */
@SpringBootApplication
@EnableEurekaClient// 开启Eureka服务发现
@EnableDiscoveryClient// 启动服务发现
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
// 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使得配置生效
public class DeptConsumer80Application {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80Application.class, args);
    }
}