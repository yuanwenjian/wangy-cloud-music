package com.yuanwj.core;

import java.util.List;

/**
 * Created by yuanwj on 2017/1/6.
 */
public class Result {

    private List entity;

    private List<Request> requests;

    public List getEntity() {
        return entity;
    }

    public void setEntity(List entity) {
        this.entity = entity;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
