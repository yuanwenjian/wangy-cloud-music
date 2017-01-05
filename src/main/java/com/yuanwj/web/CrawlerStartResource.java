package com.yuanwj.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuanwj on 2017/1/4.
 */
@RestController
@RequestMapping("/start")
public class CrawlerStartResource {
    public String test(){
        return "Hello World";
    }

}
