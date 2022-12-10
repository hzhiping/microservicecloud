package com.hzhiping.dao;

import com.hzhiping.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hzhiping
 */
@Mapper
public interface DeptDao {
    /**
     * 添加部门
     *
     * @param dept 部门
     * @return 返回是否添加成功
     */
    boolean addDept(Dept dept);

    /**
     * 根据ID找到对应的部门
     *
     * @param id 部门ID
     * @return 返回对应ID的部门
     */
    Dept findById(Long id);

    /**
     * 查询所有的部门信息
     *
     * @return 所有的部门信息
     */
    List<Dept> findAll();

}