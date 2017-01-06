package com.yuanwj.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by bmk on 17-1-5.
 */
@ConfigurationProperties(prefix = "cloudMusic")
public class SpliderConfiguration {

    private  String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
