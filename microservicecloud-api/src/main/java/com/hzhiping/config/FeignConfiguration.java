package com.hzhiping.config;

import com.hzhiping.interceptor.FeignBasicAuthReqInterceptor;
import feign.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author hzhiping
 * @date 2023/01/15
 */
@Configuration
@PropertySource(value = {"classpath:auth.properties"})
public class FeignConfiguration {
    @Autowired
    private Environment env;

    @Bean
    public FeignBasicAuthReqInterceptor basicAuthReqInterceptor() {
        String property = env.getProperty("hzhiping.authorization");
        return new FeignBasicAuthReqInterceptor(property);
    }

    @Bean
    public Contract feignContract() {
        //使用feign自带契约
        return new feign.Contract.Default();
    }
}