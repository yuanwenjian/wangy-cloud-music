package com.yuanwj.core;

import com.yuanwj.ItemPipeline.ItemPipeLine;
import com.yuanwj.download.Downloader;
import com.yuanwj.queue.RequestQueue;
import com.yuanwj.resolve.*;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanwj on 2017/1/7.
 */
@Service
public class SpliderImpl implements Splider {

    public static final Logger LOG= LoggerFactory.getLogger(SpliderImpl.class);

    @Inject
    private RequestQueue requestQueue;

    @Inject
    private Downloader downloader;

    private final Map<Request.TYPE,ResolveResponse> resolveResponseMap=new HashMap<>();

    {
        resolveResponseMap.put(Request.TYPE.MUSICLIST,new MusicListResolve());
        resolveResponseMap.put(Request.TYPE.LEAP,new LeapResolve());
        resolveResponseMap.put(Request.TYPE.SONG,new SongResolve());
        resolveResponseMap.put(Request.TYPE.USER,new UserResolve());
        resolveResponseMap.put(Request.TYPE.ROOT,new RootResolve());
    }

    private List<ItemPipeLine> itemPipeLineList=new ArrayList<>();

    @Override
    public void addItemPipeline(ItemPipeLine itemPipeLine) {
        itemPipeLineList.add(itemPipeLine);
    }

    public void addRequest(Request request){
        requestQueue.push(request);
    }

    @Scheduled(fixedRate = 300l)
    public void start(){
        Request request=requestQueue.poll();
        if(request==null){
            return;
        }
        LOG.debug("开始解析{}类型html",request.getType());
        Document document=downloader.download(request);
        Result result=getResoleve(request).resolve(document);
        for (ItemPipeLine itemPipeLine:itemPipeLineList){
            itemPipeLine.save(result);
        }
        if (result.getRequests()!=null&&result.getRequests().size()>0){
            for (Request requestTarget:result.getRequests()){
                requestQueue.push(requestTarget);
            }
        }
    }

    private ResolveResponse getResoleve(Request request){
        return resolveResponseMap.get(request.getType());
    }

}
