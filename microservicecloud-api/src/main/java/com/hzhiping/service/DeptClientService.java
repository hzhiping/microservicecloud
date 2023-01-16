package com.hzhiping.service;

import com.hzhiping.config.FeignConfiguration;
import com.hzhiping.entity.Dept;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 这边使用我们的@RequestLine标准，而不是@RequestMapping
 *
 * @author hzhiping
 * @date 2023/01/10
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT", configuration = FeignConfiguration.class)
//@Headers(value = {"Authorization: xxx"})
public interface DeptClientService {
    //@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @RequestLine("GET /dept/get/{id}")
    public Dept get(@PathVariable("id") long id);

    //@RequestMapping(value = "/dept/list", method = RequestMethod.GET, headers = {"Authorization=xxx"})
    //@Headers(value = {"Authorization=xxx"})


    @RequestLine("GET /dept/list")
    //@Headers(value = {"Authorization: xxx"})
    public List<Dept> list();

    //@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    @RequestLine("POST /dept/add")
    public boolean add(Dept dept);

    @RequestLine("GET /dept/getDeptByParams?deptNo={deptNo}&dbSource={dbSource}")
    public Dept getDeptByParams(@Param("deptNo") Long deptNo,
                                @Param("dbSource") String dbSource
    );
}