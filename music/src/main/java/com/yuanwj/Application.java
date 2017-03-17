package com.yuanwj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by yuanwj on 2017/1/18.
 */
@SpringBootApplication
@ComponentScan("com.yuanwj")
public class Application  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
//        SpringApplication application=new SpringApplication(Application.class);
//
//        ConfigurableApplicationContext context=application.run();
    }
}
