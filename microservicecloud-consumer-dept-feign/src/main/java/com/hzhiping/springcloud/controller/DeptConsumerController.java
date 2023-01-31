package com.hzhiping.springcloud.controller;

import com.hzhiping.entity.Dept;
import com.hzhiping.entity.DeptParam;
import com.hzhiping.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hzhiping
 * @date 2023/01/10
 */
@RestController
@SuppressWarnings("ALL")
public class DeptConsumerController {
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        List<Dept> deptList;
        try {
            deptList = this.deptClientService.list();
        } catch (Exception e) {
            throw new RuntimeException("数据库连接出问题了");
        }
        deptList.clear();
        if (deptList.isEmpty()) {
            throw new RuntimeException("hhhhh");
        }
        return this.deptClientService.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept) {
        return this.deptClientService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/getDeptByParams", method = RequestMethod.POST)
    public Dept getDeptByParams(@RequestBody DeptParam deptParam) {
        Long deptNo = deptParam.getDeptNo();
        String dbSource = deptParam.getDbSource();
        return this.deptClientService.getDeptByParams(deptNo, dbSource);
    }
}