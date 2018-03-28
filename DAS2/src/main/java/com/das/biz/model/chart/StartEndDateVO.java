package com.das.biz.model.chart;

import java.sql.Date;

public class StartEndDateVO {
	private Date startDate;
	private Date endDate;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public StartEndDateVO(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public StartEndDateVO() {
		super();
	}
	@Override
	public String toString() {
		return "StartEndDateVO [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
