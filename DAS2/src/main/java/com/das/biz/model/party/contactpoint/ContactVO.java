package com.das.biz.model.party.contactpoint;

public class ContactVO {
	
	private int partyId;
	private String contactType;
	private String detail;
	
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public ContactVO(int partyId, String contactType, String detail) {
		super();
		this.partyId = partyId;
		this.contactType = contactType;
		this.detail = detail;
	}
	public ContactVO() {
		super();
	}
	@Override
	public String toString() {
		return "ContactVO [partyId=" + partyId + ", contactType=" + contactType + ", detail=" + detail + "]";
	}
}
