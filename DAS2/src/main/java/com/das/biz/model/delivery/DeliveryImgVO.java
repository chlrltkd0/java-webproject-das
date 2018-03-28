package com.das.biz.model.delivery;

public class DeliveryImgVO {
	private int deliveryId;
	private String imgName;
	
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public DeliveryImgVO(int deliveryId, String imgName) {
		super();
		this.deliveryId = deliveryId;
		this.imgName = imgName;
	}
	public DeliveryImgVO() {
		super();
	}
	@Override
	public String toString() {
		return "DeliveryImgVO [deliveryId=" + deliveryId + ", imgName=" + imgName + "]";
	}
}
