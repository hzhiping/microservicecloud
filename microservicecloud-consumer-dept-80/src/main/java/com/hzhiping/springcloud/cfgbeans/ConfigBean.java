package com.hzhiping.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 这个类相当于applicationContext.xml
 *
 * @author hzhiping
 */
@Configuration
public class ConfigBean {

    /**
     * 获取RestTemplate模板
     *
     * @return {@link RestTemplate}
     */
    @Bean
    @LoadBalanced//配置负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询算法
    }


    //@Bean
    //public UserService getUserService() {
    //    return new UserServiceImpl();
    //}
    //applicationContext.xml == 加了@Configuration的ConfigBean
    //<bean id="userService" class="com.hzhiping.UserServiceImpl">
}