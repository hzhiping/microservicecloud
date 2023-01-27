package com.hzhiping.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRandomRule extends AbstractLoadBalancerRule {
    /**
     * 总共被调用的次数
     */
    private int total = 0;

    //1、当total==5的时候，指针才能往下走
    //2、index=0：当前对外提供服务的服务器地址
    //3、total需要重置为0，但是已经达到过一个5次，index=1
    //4、分析：我们5次，但是微服务只有8001，8002，8003三台可以么？
    /**
     * 当前提供服务的机器号
     */
    private int currentIndex = 0;
    public MyRandomRule() {
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            //可以到达的服务
            List<Server> upList = lb.getReachableServers();
            //所有的服务器
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if (serverCount == 0) {
                //No servers. End regardless of pass, because subsequent passes only get more restrictive.
                return null;
            }
            //自定义算法
            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }
            if (server == null) {
                //The only time this should happen is if the server list were somehow trimmed. This is a transient condition. Retry after yielding.
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            //Shouldn't actually happen, but must be transient or a bug.
            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}