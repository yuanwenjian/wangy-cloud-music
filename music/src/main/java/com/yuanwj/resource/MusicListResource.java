package com.yuanwj.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuanwj on 2017/1/18.
 */
@Controller
@RequestMapping("/musicList/")
public class MusicListResource {

    @RequestMapping("index")
    public String index(){
        return "musicList";
    }
}
