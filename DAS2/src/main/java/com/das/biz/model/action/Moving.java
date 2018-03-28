package com.das.biz.model.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.das.biz.model.partylocation.PartyLocationVO;

public class Moving {
	private int id;
	private List<PartyLocationVO> locationList = new ArrayList<>();
	private Timestamp startTime;
	private Timestamp endTime;
	private Staying fromStaying;
	private Staying toStaying;

	public void addLocationList(List<PartyLocationVO> list) {
		if(list.size()!=0) {
			if(locationList.size()==0) {
				startTime = list.get(0).getDetectTime();
			} else {
				endTime = list.get(list.size()-1).getDetectTime();
			}
			locationList.addAll(list);
		}
	}
	
	public List<PartyLocationVO> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<PartyLocationVO> locationList) {
		this.locationList = locationList;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Moving(List<PartyLocationVO> locationList, Timestamp startTime, Timestamp endTime) {
		super();
		this.locationList = locationList;
		this.startTime = startTime;
		this.endTime = endTime;
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
	
	public Staying getFromStaying() {
		return fromStaying;
	}

	public void setFromStaying(Staying fromStaying) {
		this.fromStaying = fromStaying;
	}

	public Staying getToStaying() {
		return toStaying;
	}

	public void setToStaying(Staying toStaying) {
		this.toStaying = toStaying;
	}

	public Moving() {
		super();
	}

	@Override
	public String toString() {
		return "Moving [id=" + id + ", locationList=" + locationList + ", startTime=" + startTime + ", endTime="
				+ endTime + ", fromStaying=" + fromStaying + ", toStaying=" + toStaying + "]";
	}
}
