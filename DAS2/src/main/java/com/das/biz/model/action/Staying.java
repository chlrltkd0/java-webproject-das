package com.das.biz.model.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.das.biz.model.location.LocationVO;
import com.das.biz.model.partylocation.PartyLocationVO;

/**
 * 상속처리 할수 있ㅁ으면 하도록 할것, Staying Moving Action  3ㄱ ㅐ*/
public class Staying {
	private int id;
	private List<PartyLocationVO> locationList = new ArrayList<>();
	private LocationVO location;
	private Timestamp startTime;
	private Timestamp endTime;
	
	public List<PartyLocationVO> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<PartyLocationVO> locationList) {
		if(locationList.size()!=0) {
			startTime = locationList.get(0).getDetectTime();
			endTime = locationList.get(locationList.size()-1).getDetectTime();
			this.locationList = locationList;
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Staying() {
		super();
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public LocationVO getLocation() {
		return location;
	}
	public void setLocation(LocationVO location) {
		this.location = location;
	}
	public Staying(int id, List<PartyLocationVO> locationList, LocationVO location, Timestamp startTime,
			Timestamp endTime) {
		super();
		this.id = id;
		this.locationList = locationList;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Staying [id=" + id + ", locationList=" + locationList + ", location=" + location + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
}
