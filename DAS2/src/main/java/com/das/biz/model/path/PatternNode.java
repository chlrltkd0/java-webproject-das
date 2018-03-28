package com.das.biz.model.path;

import com.das.biz.model.location.LocationVO;

public class PatternNode {
	private int id;
	private int partyId;
	private LocationVO location;
	private int locWeight;
	
	public boolean isVicinity(PartyLocationVO plvo) {
		return this.location.isVicinity(plvo.getLocation());
	}
	
	public PatternNode() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public PatternNode(int id, int partyId, LocationVO location, int locWeight) {
		super();
		this.id = id;
		this.partyId = partyId;
		this.location = location;
		this.locWeight = locWeight;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public LocationVO getLocation() {
		return location;
	}

	public void setLocation(LocationVO location) {
		this.location = location;
	}

	public int getLocWeight() {
		return locWeight;
	}

	public void setLocWeight(int locWeight) {
		this.locWeight = locWeight;
	}
	
	public PatternNode(int id, LocationVO location) {
		super();
		this.id = id;
		this.location = location;
	}

	public PatternNode(double latitude, double longitude) {
		super();
		this.location = new LocationVO(latitude, longitude);
	}

	@Override
	public String toString() {
		return "PatternNode [id=" + id + ", partyId=" + partyId + ", location=" + location + ", locWeight=" + locWeight
				+ "]";
	}
}
