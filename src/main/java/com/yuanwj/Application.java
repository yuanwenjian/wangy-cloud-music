package com.yuanwj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by yuanwj on 2017/1/4.
 */
@ComponentScan
@EnableAutoConfiguration
//@EnableConfigurationProperties({BioSearchProperties.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication application=new SpringApplication();
        ConfigurableApplicationContext context=application.run(args);
    }
}
