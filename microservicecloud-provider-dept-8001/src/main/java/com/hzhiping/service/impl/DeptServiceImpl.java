package com.hzhiping.service.impl;

import com.hzhiping.dao.DeptDao;
import com.hzhiping.entity.Dept;
import com.hzhiping.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hzhiping
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }

    @Override
    public List<Dept> findByName(String deptName) {
        return null;
    }

    @Override
    public Dept getDeptByParams(Long deptNo, String dbSource) {
        Dept dept = deptDao.findByParams(deptNo, dbSource);
        return dept;
    }
}