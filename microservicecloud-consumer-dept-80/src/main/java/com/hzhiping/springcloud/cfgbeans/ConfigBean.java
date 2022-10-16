package com.hzhiping.springcloud.cfgbeans;

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
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    //@Bean
    //public UserService getUserService() {
    //    return new UserServiceImpl();
    //}
    //applicationContext.xml == 加了@Configuration的ConfigBean
    //<bean id="userService" class="com.hzhiping.UserServiceImpl">
}