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
public class RootResolve implements ResolveResponse {

    public static final Logger LOG= LoggerFactory.getLogger(RootResolve.class);
    @Override
    public Result resolve(Document document,Request request) {
        LOG.debug("开始解析Root html");
        List<Request> requestList=new ArrayList<>();
        Result result=new Result();
        Elements elements=document.select("a.s-fc1");
        for (Element aElement:elements){
            Request requestTarget=new Request();
            String href=aElement.attr("href");
            requestTarget.setUrl(Request.BASEURL+href);
            requestTarget.setType(Request.TYPE.MUSICLIST);
            requestList.add(requestTarget);
        }
        result.setRequests(requestList);
        return result;
    }
}
