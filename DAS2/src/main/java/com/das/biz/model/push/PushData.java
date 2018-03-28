package com.das.biz.model.push;

public class PushData {
	private int partyId;
	private String endPoint;
	private String p256dh;
	private String auth;
	
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public String getP256dh() {
		return p256dh;
	}
	public void setP256dh(String p256dh) {
		this.p256dh = p256dh;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public PushData(int partyId, String endPoint, String p256dh, String auth) {
		super();
		this.partyId = partyId;
		this.endPoint = endPoint;
		this.p256dh = p256dh;
		this.auth = auth;
	}
	public PushData() {
		super();
	}
	@Override
	public String toString() {
		return "PushData [partyId=" + partyId + ", endPoint=" + endPoint + ", p256dh=" + p256dh + ", auth=" + auth
				+ "]";
	}
}
