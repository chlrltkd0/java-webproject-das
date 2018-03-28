package com.das.biz.model.party;

import java.util.List;

public class PartyListVO {
	private int page;
	private String range;
	private String keyword = "";
	private int partyCount;
	private List<PartyVO> partyList;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPartyCount() {
		return partyCount;
	}
	public void setPartyCount(int partyCount) {
		this.partyCount = partyCount;
	}
	public List<PartyVO> getPartyList() {
		return partyList;
	}
	public void setPartyList(List<PartyVO> partyList) {
		this.partyList = partyList;
	}
	public PartyListVO(int page, String range, String keyword, int partyCount, List<PartyVO> partyList) {
		super();
		this.page = page;
		this.range = range;
		this.keyword = keyword;
		this.partyCount = partyCount;
		this.partyList = partyList;
	}
	public PartyListVO() {
		super();
	}
	@Override
	public String toString() {
		return "PartyListVO [page=" + page + ", range=" + range + ", keyword=" + keyword + ", partyCount=" + partyCount
				+ ", partyList=" + partyList + "]";
	}
}
