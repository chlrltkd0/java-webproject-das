package com.das.biz.model.pattern;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.das.analyzer.RepeatAnalyzer;
import com.das.biz.model.action.Moving;
import com.das.biz.model.location.LocationVO;

public class Pattern {
	private int id;
	private int partyId;
	private LocationVO fromLocation;
	private LocationVO toLocation;
	private int repeatCount = 0;
	private List<Moving> movingList = new ArrayList<>();
	private List<String> repeatList = null;
	
	public void addMoving(Moving moving) {
		int size = movingList.size();
		if(size==0) {
			fromLocation = new LocationVO(moving.getFromStaying().getLocation());
			toLocation = new LocationVO(moving.getToStaying().getLocation());
		} else {
			fromLocation.setLatitude((fromLocation.getLatitude()*size+moving.getFromStaying().getLocation().getLatitude())/(size+1));
			fromLocation.setLongitude((fromLocation.getLongitude()*size+moving.getFromStaying().getLocation().getLongitude())/(size+1));
			toLocation.setLatitude((toLocation.getLatitude()*size+moving.getToStaying().getLocation().getLatitude())/(size+1));
			toLocation.setLongitude((toLocation.getLongitude()*size+moving.getToStaying().getLocation().getLongitude())/(size+1));
		}
		movingList.add(moving);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public LocationVO getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(LocationVO fromLocation) {
		this.fromLocation = fromLocation;
	}
	public LocationVO getToLocation() {
		return toLocation;
	}
	public void setToLocation(LocationVO toLocation) {
		this.toLocation = toLocation;
	}
	public List<Moving> getMovingList() {
		return movingList;
	}
	public void setMovingList(List<Moving> movingList) {
		this.movingList = movingList;
	}
	public List<String> getRepeatList() {
		return repeatList;
	}
	public void setRepeatList(List<String> repeatList) {
		this.repeatList = repeatList;
	}
	public int getRepeatCount() {
		return repeatCount;
	}
	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public Pattern(int id, int partyId, LocationVO fromLocation, LocationVO toLocation, int repeatCount
			, List<Moving> movingList, List<String> repeatList) {
		super();
		this.id = id;
		this.partyId = partyId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.repeatCount = repeatCount;
		this.movingList = movingList;
		this.repeatList = repeatList;
	}
	public Pattern() {
		super();
	}
	@Override
	public String toString() {
		return "Pattern [id=" + id + ", partyId=" + partyId + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", repeatCount=" + repeatCount + ", movingList=" + movingList + ", repeatList=" + repeatList + "]";
	}
}
