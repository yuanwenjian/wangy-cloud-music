package com.yuanwj.resolve;

import com.yuanwj.core.Request;
import com.yuanwj.core.Result;
import com.yuanwj.model.MusicList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanwj on 2017/1/7.
 */
public class MusicListResolve implements ResolveResponse {
    public static final Logger LOG = LoggerFactory.getLogger(MusicListResolve.class);

    @Override
    public Result resolve(Document document) {
        LOG.debug("解析歌单html");
        Elements elements = document.select("ul#m-pl-container");//歌单列表
        Elements elementsLi = elements.select("li");
        Result result=new Result();
        List<MusicList> musicLists=new ArrayList<>();
        List<Request> requests=new ArrayList<>();
        for (Element liElement:elementsLi){
            Element divElement=liElement.getElementsByTag("div").get(0);
            Element imgEle = divElement.getElementsByTag("img").get(0);//div图片位置
            Element aEle = divElement.getElementsByTag("a").get(0);//歌单链接
            Element userEle=liElement.getElementsByTag("p").get(1);
            Element userHrefEle=userEle.getElementsByTag("a").get(0);
            String imgPath=imgEle.attr("src");
            String href=aEle.attr("href");
            String title=aEle.attr("title");
            String userName=userHrefEle.attr("title");
            String userHref=userHrefEle.attr("href");
            MusicList musicList=new MusicList();
            musicList.setImgPath(imgPath);
            musicList.setUrl(Request.BASEURL + href);
            musicList.setTitle(title);
            musicList.setUserName(userName);
            musicLists.add(musicList);

            Request request=new Request();
            request.setUrl(Request.BASEURL+href);
            request.setType(Request.TYPE.LEAP);
            Request userRequest=new Request();
            userRequest.setType(Request.TYPE.USER);
            userRequest.setUrl(Request.BASEURL+userHref);
            requests.add(request);
            requests.add(userRequest);
        }
        result.setEntity(musicLists);
        result.setRequests(requests);
        return result;
    }
}
