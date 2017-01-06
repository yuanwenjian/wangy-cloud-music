package com.yuanwj.config;

import com.yuanwj.queue.RequestQueue;
import com.yuanwj.queue.RequestQueueImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yuanwj on 2017/1/4.
 */
@Configuration
public class WebConfiguration {

    @Bean
    public RequestQueue requestQueue(){
        return new RequestQueueImpl();
    }



}
