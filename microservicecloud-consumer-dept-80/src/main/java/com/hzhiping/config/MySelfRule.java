package com.hzhiping.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hzhiping
 * @date 2023/01/11
 */
@SuppressWarnings("SpringFacetCodeInspection")
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // return new RandomRule();
        return new MyRandomRule();
    }
}