package com.yuanwj.download;

import com.yuanwj.core.Request;
import org.jsoup.nodes.Document;

/**
 * Created by yuanwj on 2017/1/7.
 */
public interface Downloader {
    public Document download(Request request);
}
