package com.yuanwj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by bmk on 17-1-5.
 */
@Configuration
@EnableJpaRepositories(value = "com.yuanwj.repository")
public class RepositoryConfiguration {

}
