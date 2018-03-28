package com.das.biz.model.partylocation;

public class PartyLocationCMD {
	private float latitude;
	private float longitude;
	private long detectTime;

	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public long getDetectTime() {
		return detectTime;
	}
	public void setDetectTime(long detectTime) {
		this.detectTime = detectTime;
	}
	public PartyLocationCMD(float latitude, float longitude, long detectTime) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.detectTime = detectTime;
	}
	public PartyLocationCMD() {
		super();
	}
	@Override
	public String toString() {
		return "PartyLocationCMD [latitude=" + latitude + ", longitude=" + longitude + ", detectTime=" + detectTime
				+ "]";
	}
}
