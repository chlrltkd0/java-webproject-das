package com.das.biz.model.delivery;

import java.sql.Date;

public class ReceivingVO {
	private int id;
	private Date receivingDt;
	private boolean receiverConfirm;
	private boolean delivererConfirm;
	private String securityInfo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getReceivingDt() {
		return receivingDt;
	}
	public void setReceivingDt(Date receivingDt) {
		this.receivingDt = receivingDt;
	}
	public boolean isReceiverConfirm() {
		return receiverConfirm;
	}
	public void setReceiverConfirm(boolean receiverConfirm) {
		this.receiverConfirm = receiverConfirm;
	}
	public boolean isDelivererConfirm() {
		return delivererConfirm;
	}
	public void setDelivererConfirm(boolean delivererConfirm) {
		this.delivererConfirm = delivererConfirm;
	}
	public String getSecurityInfo() {
		return securityInfo;
	}
	public void setSecurityInfo(String securityInfo) {
		this.securityInfo = securityInfo;
	}
	public ReceivingVO(int id, Date receivingDt, boolean receiverConfirm, boolean delivererConfirm,
			String securityInfo) {
		super();
		this.id = id;
		this.receivingDt = receivingDt;
		this.receiverConfirm = receiverConfirm;
		this.delivererConfirm = delivererConfirm;
		this.securityInfo = securityInfo;
	}
	public ReceivingVO() {
		super();
	}
	@Override
	public String toString() {
		return "ReceivingVO [id=" + id + ", receivingDt=" + receivingDt + ", receiverConfirm=" + receiverConfirm
				+ ", delivererConfirm=" + delivererConfirm + ", securityInfo=" + securityInfo + "]";
	}
}
