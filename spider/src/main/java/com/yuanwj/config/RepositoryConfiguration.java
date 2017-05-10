package com.yuanwj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by bmk on 17-1-5.
 */
@Configuration
@EnableJpaRepositories(value = "com.yuanwj.repository")
public class RepositoryConfiguration {

    private final Redis redis=new Redis();

    public Redis getRedis() {
        return redis;
    }

    public static class Redis{
        private String host;
        private String port;
        private int maxActive;

        private int maxIdle;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public int getMaxActive() {
            return maxActive;
        }

        public void setMaxActive(int maxActive) {
            this.maxActive = maxActive;
        }

        public int getMaxIdle() {
            return maxIdle;
        }

        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }
    }



}
