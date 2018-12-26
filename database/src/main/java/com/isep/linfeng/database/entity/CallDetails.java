package com.isep.linfeng.database.entity;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallDetails {

    private String callTitle;
    private String callContent;
    private List<Transfer> transfers = null;
    private List<ScenarioTrip> scenarioTrip = null;
    private List<History> history = null;
    private List<Comment> comment = null;
    private transient Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public CallDetails(String callTitle, String callContent, List<Transfer> transfers, List<ScenarioTrip> scenarioTrip, List<History> history, List<Comment> comment) {
        this.callTitle = callTitle;
        this.callContent = callContent;
        this.transfers = transfers;
        this.scenarioTrip = scenarioTrip;
        this.history = history;
        this.comment = comment;
    }

    public String getCallTitle() {
        return callTitle;
    }

    public void setCallTitle(String callTitle) {
        this.callTitle = callTitle;
    }

    public String getCallContent() {
        return callContent;
    }

    public void setCallContent(String callContent) {
        this.callContent = callContent;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public List<ScenarioTrip> getScenarioTrip() {
        return scenarioTrip;
    }

    public void setScenarioTrip(List<ScenarioTrip> scenarioTrip) {
        this.scenarioTrip = scenarioTrip;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
