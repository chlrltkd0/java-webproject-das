package com.das.biz.model.action;

import java.util.ArrayList;
import java.util.List;

import com.das.biz.model.partylocation.PartyLocationVO;

public class Action {
	private List<PartyLocationVO> locationList = new ArrayList<>();
	private double latitude;
	private double longitude;
	
	public int getLocationSize() {
		return locationList.size();
	}
	public boolean isVicinity(PartyLocationVO plvo) {
		for(PartyLocationVO pl : locationList) {
			if(plvo.isVicinity(pl))
				return true;
		}
		return false;
	}
	
	public void addLocation(PartyLocationVO plvo) {
		if(locationList.size()!=0) {
			latitude = (latitude*locationList.size()+plvo.getLocation().getLatitude())/(locationList.size()+1);
			longitude = (longitude*locationList.size()+plvo.getLocation().getLongitude())/(locationList.size()+1);
		} else {
			latitude = plvo.getLocation().getLatitude();
			longitude = plvo.getLocation().getLongitude();
		}
		locationList.add(plvo);
	}

	public List<PartyLocationVO> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<PartyLocationVO> locationList) {
		this.locationList = locationList;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Action(List<PartyLocationVO> locationList, double latitude, double longitude) {
		super();
		this.locationList = locationList;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Action() {
		super();
	}

	@Override
	public String toString() {
		return "Action [locationList=" + locationList + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
