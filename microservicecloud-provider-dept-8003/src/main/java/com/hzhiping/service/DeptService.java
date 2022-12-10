package com.hzhiping.service;

import com.hzhiping.entity.Dept;

import java.util.List;

/**
 * 部门服务
 *
 * @author hzhiping
 * @date 2022/07/23
 */

public interface DeptService {
    /**
     * 添加部门
     *
     * @param dept 部门
     * @return boolean
     */
    boolean add(Dept dept);

    /**
     * 根据ID找到对应的部门
     *
     * @param id 部门ID
     * @return {@link Dept}
     */
    Dept get(Long id);

    /**
     * 查询所有的部门信息
     *
     * @return {@link List}<{@link Dept}>
     */
    List<Dept> list();

    /**
     * 按名称模糊匹配对应的部门集合
     *
     * @param deptName 部门名称
     * @return {@link List}<{@link Dept}>
     */
    @SuppressWarnings("ALL")
    List<Dept> findByName(String deptName);
}