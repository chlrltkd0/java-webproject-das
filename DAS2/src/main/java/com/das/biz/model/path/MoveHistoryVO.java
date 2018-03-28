package com.das.biz.model.path;

import java.sql.Timestamp;

public class MoveHistoryVO {
	private int id;
	private Timestamp fromDt;
	private Timestamp toDt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getFromDt() {
		return fromDt;
	}
	public void setFromDt(Timestamp fromDt) {
		this.fromDt = fromDt;
	}
	public Timestamp getToDt() {
		return toDt;
	}
	public void setToDt(Timestamp toDt) {
		this.toDt = toDt;
	}
	public MoveHistoryVO(int id, Timestamp fromDt, Timestamp toDt) {
		super();
		this.id = id;
		this.fromDt = fromDt;
		this.toDt = toDt;
	}
	public MoveHistoryVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "MoveHistoryVO [id=" + id + ", fromDt=" + fromDt + ", toDt=" + toDt + "]";
	}
}
