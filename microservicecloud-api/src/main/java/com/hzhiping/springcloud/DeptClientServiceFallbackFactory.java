package com.hzhiping.springcloud;

import com.hzhiping.entity.Dept;
import com.hzhiping.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hzhiping
 * @date 2023/01/18
 */
@Component//千万不要忘记添加这个注解
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept()
                        .setDeptNo(id)
                        .setDeptName("该ID：" + id + "没有没有对应的信息，Consumer客户端提供的降级信息，此刻服务Provider已经关闭")
                        .setDbSource("No this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept getDeptByParams(Long deptNo, String dbSource) {
                return null;
            }
        };
    }
}