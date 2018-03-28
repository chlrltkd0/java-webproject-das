package com.das.biz.commandobject;

public class InsertPatternCMD {
	
	private double fromLatitude;
	private double fromLongitude;
	private String fromAddress;
	private double toLatitude;
	private double toLongitude;
	private String toAddress;
	
	public double getFromLatitude() {
		return fromLatitude;
	}
	public void setFromLatitude(double fromLatitude) {
		this.fromLatitude = fromLatitude;
	}
	public double getFromLongitude() {
		return fromLongitude;
	}
	public void setFromLongitude(double fromLongitude) {
		this.fromLongitude = fromLongitude;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public double getToLatitude() {
		return toLatitude;
	}
	public void setToLatitude(double toLatitude) {
		this.toLatitude = toLatitude;
	}
	public double getToLongitude() {
		return toLongitude;
	}
	public void setToLongitude(double toLongitude) {
		this.toLongitude = toLongitude;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public InsertPatternCMD(double fromLatitude, double fromLongitude, String fromAddress, double toLatitude,
			double toLongitude, String toAddress) {
		super();
		this.fromLatitude = fromLatitude;
		this.fromLongitude = fromLongitude;
		this.fromAddress = fromAddress;
		this.toLatitude = toLatitude;
		this.toLongitude = toLongitude;
		this.toAddress = toAddress;
	}
	public InsertPatternCMD() {
		super();
	}
	@Override
	public String toString() {
		return "InsertPatternCMD [fromLatitude=" + fromLatitude + ", fromLongitude=" + fromLongitude + ", fromAddress="
				+ fromAddress + ", toLatitude=" + toLatitude + ", toLongitude=" + toLongitude + ", toAddress="
				+ toAddress + "]";
	}
}
