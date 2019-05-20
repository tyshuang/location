package com.yuma.pojo;

import java.io.Serializable;
import java.util.Date;

public class YumaTime implements Serializable{
    private Integer id;

    private String type;

    private String date;

    private Integer sum;

    private String location;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "YumaTime [id=" + id + ", type=" + type + ", date=" + date + ", sum=" + sum + ", location=" + location
				+ ", name=" + name + "]";
	}
    
    
}