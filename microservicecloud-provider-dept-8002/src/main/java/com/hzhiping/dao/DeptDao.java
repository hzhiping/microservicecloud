package com.hzhiping.dao;

import com.hzhiping.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hzhiping
 * @date 2023/01/16
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

    /**
     * 根据部门id和数据源查询部门信息
     *
     * @param deptNo   部门id
     * @param dbSource 数据源
     * @return {@link Dept}
     */
    Dept findByParams(@Param("deptNo") Long deptNo, @Param("dbSource") String dbSource);
}