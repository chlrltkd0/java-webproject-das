package com.das.biz.model.chart;

public class ChartVO {
	private String key;
	private int value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ChartVO(String key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
	public ChartVO() {
		super();
	}
	@Override
	public String toString() {
		return "ChartVO [key=" + key + ", value=" + value + "]";
	}
}
