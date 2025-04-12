package com.hzhiping.controller;

import com.hzhiping.entity.Dept;
import com.hzhiping.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hzhiping
 */
@RestController
public class DeptController {
    @Resource
    private DeptService service;

    /**
     * 注入服务发现的客户端
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable(name = "id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        // 获取服务
        List<String> services = discoveryClient.getServices();
        // 获取对应的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        // 遍历对应的实例并输出
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 根据部门id和数据源获取部门信息
     *
     * @param deptNo   部门id
     * @param dbSource 数据源
     * @return {@link Dept}
     */
    @RequestMapping(value = "/dept/getDeptByParams", method = RequestMethod.GET)
    public Dept getDeptByParams(@RequestParam Long deptNo, @RequestParam String dbSource) {
        return service.getDeptByParams(deptNo, dbSource);
    }
}