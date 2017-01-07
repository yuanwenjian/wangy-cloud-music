package com.yuanwj;

import com.yuanwj.config.CloudMusicConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by yuanwj on 2017/1/4.
 */
@SpringBootApplication
@EnableConfigurationProperties({CloudMusicConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication application=new SpringApplication(Application.class);
        ConfigurableApplicationContext context=application.run();
    }
}
