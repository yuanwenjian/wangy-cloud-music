package com.yuanwj.download;

import com.yuanwj.core.Request;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by yuanwj on 2017/1/7.
 */
public class DownloadImpl implements Downloader {
    public static final Logger LOG= LoggerFactory.getLogger(DownloadImpl.class);
    @Override
    public Document download(Request request) {
        CloseableHttpClient client = HttpClients.createDefault();
        LOG.debug("当前链接type为{}，url为{}",request.getType(),request.getUrl());
        HttpGet httpGet = new HttpGet(request.getUrl());
        httpGet.setHeader("Cookie","CNZZDATA1256911977=405947132-1484049377-https%253A%252F%252Fwww.baidu.com%252F%7C1484049377; _ga=GA1.2.628230727.1484052749");
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String html= EntityUtils.toString(entity);
            Document document= Jsoup.parse(html);
            return document;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
