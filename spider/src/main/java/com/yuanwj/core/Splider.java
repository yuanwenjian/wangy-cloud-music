package com.yuanwj.core;

import com.yuanwj.ItemPipeline.ItemPipeLine;

/**
 * Created by yuanwj on 2017/1/7.
 */
public interface Splider {
    public void addItemPipeline(ItemPipeLine itemPipeLine);
    public void addRequest(Request request);
}
