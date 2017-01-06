package com.yuanwj.web;

import com.yuanwj.service.MusicListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by yuanwj on 2017/1/4.
 */
@RestController
@RequestMapping("/start")
public class CrawlerStartResource {

    @Inject
    private MusicListService musicListService;

    @RequestMapping("/test")
    public String test(){
        musicListService.findAll();
        return "Hello World";
    }

}
