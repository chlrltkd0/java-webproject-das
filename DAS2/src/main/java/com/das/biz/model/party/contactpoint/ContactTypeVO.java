package com.das.biz.model.party.contactpoint;

public class ContactTypeVO {
	
	private String type;
	private String isRequired;
	
	public ContactTypeVO(String type, String isRequired) {
		super();
		this.type = type;
		this.isRequired = isRequired;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

	public ContactTypeVO() {
		super();
	}
}
