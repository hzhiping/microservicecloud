package com.hzhiping.service;

import com.hzhiping.entity.Dept;
import com.hzhiping.entity.DeptParam;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author hzhiping
 * @date 2023/01/16
 */
@FeignClient(value = "dept-client", url = "http://localhost:80")
public interface LongLinkDeptClient {
    @RequestLine("POST /consumer/dept/getDeptByParams")
    Dept getDeptByParams(DeptParam deptParam);
}