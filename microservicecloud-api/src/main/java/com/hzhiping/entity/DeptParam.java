package com.hzhiping.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hzhiping
 * @date 2023/01/16
 */
@Data
@Accessors(chain = true)
public class DeptParam {
    private Long deptNo;
    private String dbSource;
}