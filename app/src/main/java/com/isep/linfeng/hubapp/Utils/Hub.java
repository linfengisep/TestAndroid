package com.isep.linfeng.hubapp.Utils;
import com.isep.linfeng.database.entity.CallDetails;

import java.util.HashMap;
import java.util.Map;

public class Hub {

    private String messageType;
    private String title;
    private String subTitle;
    private String content;
    private String time;
    private Boolean isStar;
    private String callDetails;
    private transient Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Hub(String messageType, String title, String subTitle, String content, String time, Boolean isStar, String callDetails) {
        this.messageType = messageType;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.time = time;
        this.isStar = isStar;
        this.callDetails = callDetails;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getIsStar() {
        return isStar;
    }

    public void setIsStar(Boolean isStar) {
        this.isStar = isStar;
    }

    public String getCallDetails() {
        return callDetails;
    }

    public void setCallDetails(String callDetails) {
        this.callDetails = callDetails;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
