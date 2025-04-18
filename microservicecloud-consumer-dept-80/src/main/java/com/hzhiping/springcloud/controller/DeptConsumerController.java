package com.hzhiping.springcloud.controller;

import com.hzhiping.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author hzhiping
 * @date 2022/10/29
 */
@RestController
public class DeptConsumerController {
    // private static final String REST_URL_PREFIX = "http://localhost:8001";
    /**
     * 修改为访问为服务的地址名
     */
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    /**
     * 使用RestTemplate访问RESTful接口非常的简单无脑粗暴。
     * (url, requestMap, ResponseBean.class)这三个参数分别代表REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * http://localhost/consumer/dept/add?deptName=bigdata
     *
     * @param dept 部门
     * @return boolean
     */
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(DeptConsumerController.REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(DeptConsumerController.REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @SuppressWarnings("ALL")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(DeptConsumerController.REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(DeptConsumerController.REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}