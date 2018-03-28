package com.das.biz.model.delivery;

import java.sql.Timestamp;
import java.util.List;

import com.das.biz.model.party.PartyVO;

public class DeliveryVO {
	
	private int id;
	private int senderId;
	private int receiverId;
	private int delivererId;
	private String sendingLoc;
	private double sendingLatitude;
	private double sendingLongitude;
	private String receivingLoc;
	private double receivingLatitude;
	private double receivingLongitude;
	private Timestamp sendingDt;
	private Timestamp receivingDt;
	private String sendingType;
	private String receivingType;
	private int chargeAmt;
	private int grade;
	private String itemType;
	private int itemWidth;
	private int itemLength;
	private int itemHeight;
	private int itemWeight;
	private int itemValue;
	private SendingVO sendingVO;
	private ReceivingVO receivingVO;
	
	private List<PartyVO> delivererList;

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

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public int getDelivererId() {
		return delivererId;
	}

	public void setDelivererId(int delivererId) {
		this.delivererId = delivererId;
	}

	public String getSendingLoc() {
		return sendingLoc;
	}

	public void setSendingLoc(String sendingLoc) {
		this.sendingLoc = sendingLoc;
	}

	public double getSendingLatitude() {
		return sendingLatitude;
	}

	public void setSendingLatitude(double sendingLatitude) {
		this.sendingLatitude = sendingLatitude;
	}

	public double getSendingLongitude() {
		return sendingLongitude;
	}

	public void setSendingLongitude(double sendingLongitude) {
		this.sendingLongitude = sendingLongitude;
	}

	public String getReceivingLoc() {
		return receivingLoc;
	}

	public void setReceivingLoc(String receivingLoc) {
		this.receivingLoc = receivingLoc;
	}

	public double getReceivingLatitude() {
		return receivingLatitude;
	}

	public void setReceivingLatitude(double receivingLatitude) {
		this.receivingLatitude = receivingLatitude;
	}

	public double getReceivingLongitude() {
		return receivingLongitude;
	}

	public void setReceivingLongitude(double receivingLongitude) {
		this.receivingLongitude = receivingLongitude;
	}

	public Timestamp getSendingDt() {
		return sendingDt;
	}

	public void setSendingDt(Timestamp sendingDt) {
		this.sendingDt = sendingDt;
	}

	public Timestamp getReceivingDt() {
		return receivingDt;
	}

	public void setReceivingDt(Timestamp receivingDt) {
		this.receivingDt = receivingDt;
	}

	public String getSendingType() {
		return sendingType;
	}

	public void setSendingType(String sendingType) {
		this.sendingType = sendingType;
	}

	public String getReceivingType() {
		return receivingType;
	}

	public void setReceivingType(String receivingType) {
		this.receivingType = receivingType;
	}

	public int getChargeAmt() {
		return chargeAmt;
	}

	public void setChargeAmt(int chargeAmt) {
		this.chargeAmt = chargeAmt;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(int itemWidth) {
		this.itemWidth = itemWidth;
	}

	public int getItemLength() {
		return itemLength;
	}

	public void setItemLength(int itemLength) {
		this.itemLength = itemLength;
	}

	public int getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(int itemHeight) {
		this.itemHeight = itemHeight;
	}

	public int getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(int itemWeight) {
		this.itemWeight = itemWeight;
	}

	public int getItemValue() {
		return itemValue;
	}

	public void setItemValue(int itemValue) {
		this.itemValue = itemValue;
	}

	public SendingVO getSendingVO() {
		return sendingVO;
	}

	public void setSendingVO(SendingVO sendingVO) {
		this.sendingVO = sendingVO;
	}

	public ReceivingVO getReceivingVO() {
		return receivingVO;
	}

	public void setReceivingVO(ReceivingVO receivingVO) {
		this.receivingVO = receivingVO;
	}

	public List<PartyVO> getDelivererList() {
		return delivererList;
	}

	public void setDelivererList(List<PartyVO> delivererList) {
		this.delivererList = delivererList;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public DeliveryVO(int id, int senderId, int receiverId, int delivererId, String sendingLoc, double sendingLatitude,
			double sendingLongitude, String receivingLoc, double receivingLatitude, double receivingLongitude,
			Timestamp sendingDt, Timestamp receivingDt, String sendingType, String receivingType, int chargeAmt,
			int grade, String itemType, int itemWidth, int itemLength, int itemHeight, int itemWeight, int itemValue,
			SendingVO sendingVO, ReceivingVO receivingVO, List<PartyVO> delivererList) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.delivererId = delivererId;
		this.sendingLoc = sendingLoc;
		this.sendingLatitude = sendingLatitude;
		this.sendingLongitude = sendingLongitude;
		this.receivingLoc = receivingLoc;
		this.receivingLatitude = receivingLatitude;
		this.receivingLongitude = receivingLongitude;
		this.sendingDt = sendingDt;
		this.receivingDt = receivingDt;
		this.sendingType = sendingType;
		this.receivingType = receivingType;
		this.chargeAmt = chargeAmt;
		this.grade = grade;
		this.itemType = itemType;
		this.itemWidth = itemWidth;
		this.itemLength = itemLength;
		this.itemHeight = itemHeight;
		this.itemWeight = itemWeight;
		this.itemValue = itemValue;
		this.sendingVO = sendingVO;
		this.receivingVO = receivingVO;
		this.delivererList = delivererList;
	}

	public DeliveryVO() {
		super();
	}

	@Override
	public String toString() {
		return "DeliveryVO [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", delivererId="
				+ delivererId + ", sendingLoc=" + sendingLoc + ", sendingLatitude=" + sendingLatitude
				+ ", sendingLongitude=" + sendingLongitude + ", receivingLoc=" + receivingLoc + ", receivingLatitude="
				+ receivingLatitude + ", receivingLongitude=" + receivingLongitude + ", sendingDt=" + sendingDt
				+ ", receivingDt=" + receivingDt + ", sendingType=" + sendingType + ", receivingType=" + receivingType
				+ ", chargeAmt=" + chargeAmt + ", grade=" + grade + ", itemType=" + itemType + ", itemWidth="
				+ itemWidth + ", itemLength=" + itemLength + ", itemHeight=" + itemHeight + ", itemWeight=" + itemWeight
				+ ", itemValue=" + itemValue + ", sendingVO=" + sendingVO + ", receivingVO=" + receivingVO
				+ ", delivererList=" + delivererList + "]";
	}
}
