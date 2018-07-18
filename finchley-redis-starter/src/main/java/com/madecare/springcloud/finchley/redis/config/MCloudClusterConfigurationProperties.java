package com.madecare.springcloud.finchley.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.List;

/**
 * @Author: xuyangyang
 * @Description: Mcloud Spring boot starter ConfigurationProperties
 * @Date: 2018/7/10 9:10
 */
@ConfigurationProperties(prefix = "mcloud.redis")
public class MCloudClusterConfigurationProperties {

    private String password;

    private final MCloudClusterConfigurationProperties.Jedis jedis = new MCloudClusterConfigurationProperties.Jedis();

    private MCloudClusterConfigurationProperties.Cluster cluster;

    private boolean ssl;

    /**
     * Connection timeout.
     */
    private Duration timeout;

    public Jedis getJedis() {
        return jedis;
    }

    public MCloudClusterConfigurationProperties.Cluster getCluster() {
        return cluster;
    }

    public void setCluster(MCloudClusterConfigurationProperties.Cluster cluster) {
        this.cluster = cluster;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Jedis client properties.
     */
    public static class Jedis {

        /**
         * Jedis pool configuration.
         */
        private MCloudClusterConfigurationProperties.Pool pool;

        public MCloudClusterConfigurationProperties.Pool getPool() {
            return this.pool;
        }

        public void setPool(MCloudClusterConfigurationProperties.Pool pool) {
            this.pool = pool;
        }
    }

    public static class Pool {

        /**
         * Maximum number of "idle" connections in the pool. Use a negative value to
         * indicate an unlimited number of idle connections.
         */
        private int maxIdle = 8;

        /**
         * Target for the minimum number of idle connections to maintain in the pool. This
         * setting only has an effect if it is positive.
         */
        private int minIdle = 0;

        /**
         * Maximum number of connections that can be allocated by the pool at a given
         * time. Use a negative value for no limit.
         */
        private int maxActive = 8;

        /**
         * Maximum amount of time a connection allocation should block before throwing an
         * exception when the pool is exhausted. Use a negative value to block
         * indefinitely.
         */
        private Duration maxWait = Duration.ofMillis(-1);

        public int getMaxIdle() {
            return this.maxIdle;
        }

        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }

        public int getMinIdle() {
            return this.minIdle;
        }

        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }

        public int getMaxActive() {
            return this.maxActive;
        }

        public void setMaxActive(int maxActive) {
            this.maxActive = maxActive;
        }

        public Duration getMaxWait() {
            return this.maxWait;
        }

        public void setMaxWait(Duration maxWait) {
            this.maxWait = maxWait;
        }

    }

    public static class Cluster {

        /**
         * Comma-separated list of "host:port" pairs to bootstrap from. This represents an
         * "initial" list of cluster nodes and is required to have at least one entry.
         */
        private List<String> nodes;

        /**
         * Maximum number of redirects to follow when executing commands across the
         * cluster.
         */
        private Integer maxRedirects;

        public List<String> getNodes() {
            return this.nodes;
        }

        public void setNodes(List<String> nodes) {
            this.nodes = nodes;
        }

        public Integer getMaxRedirects() {
            return this.maxRedirects;
        }

        public void setMaxRedirects(Integer maxRedirects) {
            this.maxRedirects = maxRedirects;
        }

    }
}