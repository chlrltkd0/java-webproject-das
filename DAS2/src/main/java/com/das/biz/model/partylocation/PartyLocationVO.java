package com.das.biz.model.partylocation;

import java.sql.Timestamp;

import com.das.biz.model.location.LocationVO;

public class PartyLocationVO {
	private LocationVO location;
    private Timestamp detectTime;
    private int partyId;
    
    public boolean isVicinity(PartyLocationVO plvo) {
    	return location.isVicinity(plvo.getLocation());
    }
    
	public LocationVO getLocation() {
		return location;
	}
	public void setLocation(LocationVO location) {
		this.location = location;
	}
	public Timestamp getDetectTime() {
		return detectTime;
	}
	public void setDetectTime(Timestamp detectTime) {
		this.detectTime = detectTime;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public PartyLocationVO(LocationVO location, Timestamp detectTime, int partyId) {
		super();
		this.location = location;
		this.detectTime = detectTime;
		this.partyId = partyId;
	}
	public PartyLocationVO() {
		super();
	}
	@Override
	public String toString() {
		return "PartyLocationVO [location=" + location + ", detectTime=" + detectTime + ", partyId=" + partyId + "]";
	}
}
