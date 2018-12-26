package com.isep.linfeng.database.entity;



import java.util.HashMap;
import java.util.Map;

public class Transfer {

    private String name;
    private String duration;
    private String date;
    private transient Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public Transfer(String name, String duration, String date) {
		super();
		this.name = name;
		this.duration = duration;
		this.date = date;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Transfer [name=" + name + ", duration=" + duration + ", date=" + date + "]";
	}
    
    

}
