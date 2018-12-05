package com.kaihei.esportingplus.user.event;

import com.kaihei.esportingplus.common.event.Event;

import java.util.List;

/**
 * @author liuyang
 * @Description
 * @Date 2018/12/3 16:10
 **/
public  class UnFollowEvent implements Event {
    private String uid;
    private List<String> followId;

    public UnFollowEvent(String uid, List<String> followId) {
        this.uid = uid;
        this.followId = followId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<String> getFollowId() {
        return followId;
    }

    public void setFollowId(List<String> followId) {
        this.followId = followId;
    }
}