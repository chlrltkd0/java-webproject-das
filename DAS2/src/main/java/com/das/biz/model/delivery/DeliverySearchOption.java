package com.das.biz.model.delivery;

public class DeliverySearchOption {
	private int id = 0;
	private int senderId = 0;
	private int delivererId = 0;
	private int receiverId = 0;
	private String sendingLoc = "";
	private String receivingLoc = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getDelivererId() {
		return delivererId;
	}
	public void setDelivererId(int delivererId) {
		this.delivererId = delivererId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getSendingLoc() {
		return sendingLoc;
	}
	public void setSendingLoc(String sendingLoc) {
		this.sendingLoc = sendingLoc;
	}
	public String getReceivingLoc() {
		return receivingLoc;
	}
	public void setReceivingLoc(String receivingLoc) {
		this.receivingLoc = receivingLoc;
	}
	public DeliverySearchOption(int id, int senderId, int delivererId, int receiverId, String sendingLoc,
			String receivingLoc) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.delivererId = delivererId;
		this.receiverId = receiverId;
		this.sendingLoc = sendingLoc;
		this.receivingLoc = receivingLoc;
	}
	public DeliverySearchOption() {
		super();
	}
	@Override
	public String toString() {
		return "DeliverySearchOption [id=" + id + ", senderId=" + senderId + ", delivererId=" + delivererId
				+ ", receiverId=" + receiverId + ", sendingLoc=" + sendingLoc + ", receivingLoc=" + receivingLoc + "]";
	}
}
