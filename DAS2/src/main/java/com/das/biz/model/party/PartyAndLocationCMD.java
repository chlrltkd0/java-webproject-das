package com.das.biz.model.party;

import java.util.ArrayList;

import com.das.biz.model.path.PartyLocationCMD;

public class PartyAndLocationCMD {
	
	private String LoginId;
	private String LoginPwd;
	private ArrayList<PartyLocationCMD> PLList;

	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		LoginId = loginId;
	}

	public String getLoginPwd() {
		return LoginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}

	public ArrayList<PartyLocationCMD> getPLList() {
		return PLList;
	}

	public void setPLList(ArrayList<PartyLocationCMD> pLList) {
		PLList = pLList;
	}

	public PartyAndLocationCMD(String loginId, String loginPwd, ArrayList<PartyLocationCMD> pLList) {
		super();
		LoginId = loginId;
		LoginPwd = loginPwd;
		PLList = pLList;
	}

	public PartyAndLocationCMD() {
		super();
	}

	@Override
	public String toString() {
		return "PartyAndLocationCMD [LoginId=" + LoginId + ", LoginPwd=" + LoginPwd + ", PLList=" + PLList + "]";
	}
}
