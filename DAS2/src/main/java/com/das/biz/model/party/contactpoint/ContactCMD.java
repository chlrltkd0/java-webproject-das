package com.das.biz.model.party.contactpoint;

import java.util.ArrayList;
import java.util.List;

public class ContactCMD {
	private String address;
	private String phone;
	private String eMail;
	private String kakao_id;
	
	public ContactCMD(String address, String phone, String eMail, String kakao_id) {
		super();
		this.address = address;
		this.phone = phone;
		this.eMail = eMail;
		this.kakao_id = kakao_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getKakao_id() {
		return kakao_id;
	}

	public void setKakao_id(String kakao_id) {
		this.kakao_id = kakao_id;
	}

	public List<ContactVO> convertContactVO(){
		List<ContactVO> retList = new ArrayList<>();
		
		if(this.address!=null) {
			retList.add(new ContactVO(0, "address", this.address));
		}
		
		if(this.phone!=null) {
			retList.add(new ContactVO(0, "phone", this.phone));
		}
		
		if(this.eMail!=null) {
			retList.add(new ContactVO(0, "eMail", this.eMail));
		}
		
		if(this.kakao_id!=null) {
			retList.add(new ContactVO(0, "kakao_id", this.kakao_id));
		}
		
		return retList;
	}
	
	public ContactCMD() {
		super();
	}
	@Override
	public String toString() {
		return "ContactCMD [address=" + address + ", phone=" + phone + ", email=" + eMail + ", kakaotalk=" + kakao_id
				+ "]";
	}
}
