package com.yuanwj.web;

import com.yuanwj.core.Request;
import com.yuanwj.core.Splider;
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

    @Inject
    private Splider splider;

    @RequestMapping("/musicList")
    public String musicList(){
        Request request=new Request();
        request.setUrl(Request.BASEURL+"/discover/playlist");
        request.setType(Request.TYPE.ROOT);
        splider.addRequest(request);
        return "Hello World";
    }

    @RequestMapping("/leap")
    public String leap(){
        Request request=new Request();
        request.setUrl("http://music.163.com/playlist?id=554154966");
        request.setType(Request.TYPE.LEAP);
        splider.addRequest(request);
        return "success";
    }

    @RequestMapping("/song")
    public String song(){
        Request request=new Request();
        request.setUrl("http://music.163.com/song?id=32507038");
        request.setType(Request.TYPE.SONG);
        splider.addRequest(request);
        return "success";
    }

}
