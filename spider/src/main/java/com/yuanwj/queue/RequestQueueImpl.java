package com.yuanwj.queue;

import com.yuanwj.core.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by bmk on 17-1-6.
 */
public class RequestQueueImpl implements RequestQueue {

    public static final Logger LOG= LoggerFactory.getLogger(RequestQueueImpl.class);


    private PriorityBlockingQueue<Request> requestQueue=new PriorityBlockingQueue<>();

    @Override
    public void push(Request request) {
        requestQueue.put(request);
        LOG.debug("queue push 当前size为{}",requestQueue.size());

    }

    @Override
    public Request poll() {
        Request request=requestQueue.poll();
        LOG.debug("queue poll 当前size为{}",requestQueue.size());
        return request;
    }
}
