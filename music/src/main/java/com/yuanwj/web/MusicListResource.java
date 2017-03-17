package com.yuanwj.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bmk on 17-1-20.
 */
@Controller
@RequestMapping(value = "/musicList/")
public class MusicListResource {

    public static final Logger LOG = LoggerFactory.getLogger(MusicListResource.class);

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request) {
        String path = request.getContextPath();
        return "musicList";
    }
}
