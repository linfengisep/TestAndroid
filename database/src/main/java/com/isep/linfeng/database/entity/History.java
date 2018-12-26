package com.isep.linfeng.database.entity;



import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class History implements Serializable {

    private String time;
    private String type;
    private String duration;
    private transient Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public History() {}
    
    public History(String time, String type, String duration) {
		super();
		this.time = time;
		this.type = type;
		this.duration = duration;
	}

	public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "History [time=" + time + ", type=" + type + ", duration=" + duration + "]";
	}

    
}
