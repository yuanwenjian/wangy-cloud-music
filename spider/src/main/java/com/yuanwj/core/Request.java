package com.yuanwj.core;

/**
 * Created by bmk on 17-1-6.
 */
public class Request implements Comparable<Request> {
    private TYPE type;

    public static final String BASEURL = "http://music.163.com";

    private String url;

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int compareTo(Request other) {
        return this.getType().ordinal() - other.getType().ordinal();
    }


    public enum TYPE {
        ROOT,MUSICLIST, SONG,LEAP, USER
    }
}
