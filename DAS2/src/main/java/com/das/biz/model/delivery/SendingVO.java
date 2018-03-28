package com.das.biz.model.delivery;

import java.sql.Date;

public class SendingVO {
	private int id;
	private Date sendingDt;
	private boolean senderConfirm;
	private boolean delivererConfirm;
	private String securityInfo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSendingDt() {
		return sendingDt;
	}
	public void setSendingDt(Date sendingDt) {
		this.sendingDt = sendingDt;
	}
	public boolean isSenderConfirm() {
		return senderConfirm;
	}
	public void setSenderConfirm(boolean senderConfirm) {
		this.senderConfirm = senderConfirm;
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
	public SendingVO(int id, Date sendingDt, boolean senderConfirm, boolean delivererConfirm, String securityInfo) {
		super();
		this.id = id;
		this.sendingDt = sendingDt;
		this.senderConfirm = senderConfirm;
		this.delivererConfirm = delivererConfirm;
		this.securityInfo = securityInfo;
	}
	public SendingVO() {
		super();
	}
	@Override
	public String toString() {
		return "SendingVO [id=" + id + ", sendingDt=" + sendingDt + ", senderConfirm=" + senderConfirm
				+ ", delivererConfirm=" + delivererConfirm + ", securityInfo=" + securityInfo + "]";
	}
}
