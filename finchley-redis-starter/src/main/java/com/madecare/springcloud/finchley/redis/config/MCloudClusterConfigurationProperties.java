package com.madecare.springcloud.finchley.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xuyangyang
 * @Description: TODO
 * @Date: 2018/7/10 9:10
 */
@ConfigurationProperties(prefix = "mcloud.redis.cluster")
public class MCloudClusterConfigurationProperties {

    /*
     * spring.redis.cluster.nodes[0] = 127.0.0.1:7379
     * spring.redis.cluster.nodes[1] = 127.0.0.1:7380
     * ...
     */
    private List<String> nodes;

    /**
     * Get initial collection of known cluster nodes in format {@code host:port}.
     *
     * @return
     */
    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}