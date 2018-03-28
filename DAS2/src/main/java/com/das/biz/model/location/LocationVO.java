package com.das.biz.model.location;

public class LocationVO {
	
	static final double range = 0.005;
	
	private String address;
	private double latitude;
	private double longitude;
	
	public boolean isVicinity(LocationVO lvo) {
		if(Math.abs(latitude-lvo.getLatitude()) <= range && Math.abs(longitude-lvo.getLongitude()) <= range)
			return true;
		return false;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public LocationVO(LocationVO locationVO) {
		super();
		this.address = locationVO.getAddress();
		this.latitude = locationVO.getLatitude();
		this.longitude= locationVO.getLongitude();
	}
	public LocationVO(String address, double latitude, double longitude) {
		super();
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public LocationVO(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public LocationVO(String address) {
		super();
		this.address = address;
	}
	public LocationVO() {
		super();
	}
	@Override
	public String toString() {
		return "LocationVO [address=" + address + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}
