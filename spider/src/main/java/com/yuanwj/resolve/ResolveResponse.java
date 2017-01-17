package com.yuanwj.resolve;

import com.yuanwj.core.Request;
import com.yuanwj.core.Result;
import org.jsoup.nodes.Document;

/**
 * Created by yuanwj on 2017/1/6.
 */
public interface ResolveResponse {
    public Result resolve(Document document,Request request);
}
