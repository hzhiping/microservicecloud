package com.hzhiping.controller;

import com.hzhiping.entity.Dept;
import com.hzhiping.entity.DeptParam;
import com.hzhiping.service.LongLinkDeptClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzhiping
 * @date 2023/01/16
 */
@RestController
public class LongLinkController {
    @Autowired
    private LongLinkDeptClient longLinkDeptClient;

    /**
     * 根据部门id和数据源获取部门信息
     *
     * @param deptNo   部门id
     * @param dbSource 数据源
     * @return {@link Dept}
     */
    @RequestMapping(value = "/dept/getDeptByParams", method = RequestMethod.GET)
    public Dept getDeptByParams(@RequestParam Long deptNo, @RequestParam String dbSource) {
        DeptParam param = new DeptParam();
        param.setDeptNo(deptNo).setDbSource(dbSource);
        return longLinkDeptClient.getDeptByParams(param);
    }
}