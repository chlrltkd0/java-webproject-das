package com.das.biz.model.chatting;

import java.sql.Timestamp;

public class ChattingVO {
	private int id;
	private int deliveryId;
	private int partyId;
	private String message;
	private Timestamp regDt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getRegDt() {
		return regDt;
	}
	public void setRegDt(Timestamp regDt) {
		this.regDt = regDt;
	}
	public ChattingVO(int id, int deliveryId, int partyId, String message, Timestamp regDt) {
		super();
		this.id = id;
		this.deliveryId = deliveryId;
		this.partyId = partyId;
		this.message = message;
		this.regDt = regDt;
	}
	public ChattingVO() {
		super();
	}
	@Override
	public String toString() {
		return "ChattingVO [id=" + id + ", deliveryId=" + deliveryId + ", partyId=" + partyId + ", message=" + message
				+ ", regDt=" + regDt + "]";
	}
}