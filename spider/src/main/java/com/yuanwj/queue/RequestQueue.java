package com.yuanwj.queue;

import com.yuanwj.core.Request;

/**
 * Created by bmk on 17-1-6.
 */
public interface RequestQueue {
    public void push(Request request);

    public Request poll();
}
