package com.das.biz.model.pattern;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.das.biz.model.action.Moving;
import com.das.biz.model.location.LocationVO;

public class Pattern {
	private int id;
	private int partyId;
	private LocationVO fromLocation;
	private LocationVO toLocation;
	private Time startFirstTime;
	private Time startLastTime;
	private Time endFirstTime;
	private Time endLastTime;
	private int repeatCount = 0;
	private List<Moving> movingList = new ArrayList<>();
	private List<String> repeatList = null;
	private List<PatternDay> pdtList;
	
	public void addMoving(Moving moving) {
		int size = movingList.size();
		if(size==0) {
			fromLocation = new LocationVO(moving.getFromStaying().getLocation());
			toLocation = new LocationVO(moving.getToStaying().getLocation());
			startFirstTime = new Time(moving.getStartTime().getTime());
			startLastTime = new Time(moving.getStartTime().getTime());
			endFirstTime = new Time(moving.getEndTime().getTime());
			endLastTime = new Time(moving.getEndTime().getTime());
		} else {
			fromLocation.setLatitude((fromLocation.getLatitude()*size+moving.getFromStaying().getLocation().getLatitude())/(size+1));
			fromLocation.setLongitude((fromLocation.getLongitude()*size+moving.getFromStaying().getLocation().getLongitude())/(size+1));
			toLocation.setLatitude((toLocation.getLatitude()*size+moving.getToStaying().getLocation().getLatitude())/(size+1));
			toLocation.setLongitude((toLocation.getLongitude()*size+moving.getToStaying().getLocation().getLongitude())/(size+1));
			
			Time startTime = new Time(moving.getStartTime().getTime());
			Time endTime = new Time(moving.getEndTime().getTime());
			if(startFirstTime.before(startTime)){
				startFirstTime = startTime;
			} else if(startLastTime.after(startTime)) {
				startLastTime = startTime;
			}
			
			if(endFirstTime.before(endTime)){
				endFirstTime = endTime;
			} else if(endLastTime.after(endTime)) {
				endLastTime = endTime;
			}
			
		}
		movingList.add(moving);
	}
	
	public boolean timeCompare(Moving moving) {
		boolean result = false;
		if((startFirstTime.getHours() < moving.getStartTime().getHours() && startLastTime.getHours() > moving.getStartTime().getHours())
				|| (Math.abs(startFirstTime.getHours()-moving.getStartTime().getHours())<2))
			if((endFirstTime.getHours() < moving.getEndTime().getHours() && endLastTime.getHours() > moving.getEndTime().getHours())
					|| (Math.abs(endFirstTime.getHours()-moving.getEndTime().getHours())<2))
				return true;
		return result;
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

	public Pattern(int id, int partyId, LocationVO fromLocation, LocationVO toLocation, Time startFirstTime,
			Time startLastTime, Time endFirstTime, Time endLastTime, int repeatCount, List<Moving> movingList,
			List<String> repeatList, List<PatternDay> pdtList) {
		super();
		this.id = id;
		this.partyId = partyId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.startFirstTime = startFirstTime;
		this.startLastTime = startLastTime;
		this.endFirstTime = endFirstTime;
		this.endLastTime = endLastTime;
		this.repeatCount = repeatCount;
		this.movingList = movingList;
		this.repeatList = repeatList;
		this.pdtList = pdtList;
	}

	public Time getStartFirstTime() {
		return startFirstTime;
	}

	public void setStartFirstTime(Time startFirstTime) {
		this.startFirstTime = startFirstTime;
	}

	public Time getStartLastTime() {
		return startLastTime;
	}

	public void setStartLastTime(Time startLastTime) {
		this.startLastTime = startLastTime;
	}

	public Time getEndFirstTime() {
		return endFirstTime;
	}

	public void setEndFirstTime(Time endFirstTime) {
		this.endFirstTime = endFirstTime;
	}

	public Time getEndLastTime() {
		return endLastTime;
	}

	public void setEndLastTime(Time endLastTime) {
		this.endLastTime = endLastTime;
	}

	public List<PatternDay> getPdtList() {
		return pdtList;
	}

	public void setPdtList(List<PatternDay> pdtList) {
		this.pdtList = pdtList;
	}

	public Pattern() {
		super();
	}

	@Override
	public String toString() {
		return "Pattern [id=" + id + ", partyId=" + partyId + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", startFirstTime=" + startFirstTime + ", startLastTime=" + startLastTime
				+ ", endFirstTime=" + endFirstTime + ", endLastTime=" + endLastTime + ", repeatCount=" + repeatCount
				+ ", movingList=" + movingList + ", repeatList=" + repeatList + ", pdtList=" + pdtList + "]";
	}
}
