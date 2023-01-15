package com.hzhiping.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.Data;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author hzhiping
 * @date 2023/01/15
 */
@Data
public class FeignBasicAuthReqInterceptor implements RequestInterceptor {
    private String authorization;


    public FeignBasicAuthReqInterceptor(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public void apply(RequestTemplate template) {
        //1、在apply中统一设置认证
        template.header("Authorization", this.authorization);
        System.out.println("统一设置header");
        //2、拦截获取请求header的信息并输出，不设置转发
        //getHeaderInfo(template);
    }

    public void getHeaderInfo(RequestTemplate template) {
        //项目如果集成了hystrix，并且在配置文件设置feign.hystrix.enabled=true，那么线程就会发生切换，
        //而RequestContextHolder.getRequestAttributes()是通过ThreadLocal获取的信息，这时候就会导致空指针异常
        //解决方法：feign.hystrix.enabled=false
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        Enumeration<String> headerNames = req.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String value = req.getHeader(name);
                System.out.println("当前请求的请求头信息：" + name + ":" + value);
            }
        }
    }
}