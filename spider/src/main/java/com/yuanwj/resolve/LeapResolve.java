package com.yuanwj.resolve;

import com.yuanwj.core.Request;
import com.yuanwj.core.Result;
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
public class LeapResolve implements ResolveResponse {

    public static final Logger LOG= LoggerFactory.getLogger(LeapResolve.class);
    @Override
    public Result resolve(Document document,Request request) {
        LOG.debug("开始解析leap html,生成song链接");
        Result result=new Result();
        try {
            Elements elements=document.select("#song-list-pre-cache");
            Elements ulElement=elements.select("ul").select("li");
            List<Request> requests=new ArrayList<>();
            for (Element liElement:ulElement){
                Element aElement=liElement.getElementsByTag("a").get(0);
                String href=aElement.attr("href");
                Request requestTarget=new Request();
                requestTarget.setUrl(Request.BASEURL+href);
                requestTarget.setType(Request.TYPE.SONG);
                requestTarget.setParam(request.getParam());
                requests.add(requestTarget);
            }
            result.setRequests(requests);

        }catch (Exception e){

            e.printStackTrace();
        }
        return result;
    }
}
