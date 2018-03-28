package com.das.biz.model.chart;

import java.sql.Date;

public class DeliveryVolumeVO {
	private Date date;
	private int count;

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public DeliveryVolumeVO(Date date, int count) {
		super();
		this.date = date;
		this.count = count;
	}
	
	public DeliveryVolumeVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "DeliveryVolumeVO [date=" + date + ", count=" + count + "]";
	}
}
