package com.das.biz.model.delivery;

public class SearchConditionVO {
	private String src = "";
	private String dst = "";
	private int page = 0;
	
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public SearchConditionVO(String src, String dst, int page) {
		super();
		this.src = src;
		this.dst = dst;
		this.page = page;
	}
	public SearchConditionVO() {
		super();
	}
	@Override
	public String toString() {
		return "SearchCondition [src=" + src + ", dst=" + dst + ", page=" + page + "]";
	}
}
