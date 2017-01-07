package com.yuanwj.resolve;

import com.yuanwj.core.Result;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuanwj on 2017/1/7.
 */
public class UserResolve implements ResolveResponse {
    private Logger LOG= LoggerFactory.getLogger(UserResolve.class);
    @Override
    public Result resolve(Document document) {
        LOG.debug("解析用户html");
        return null;
    }
}
