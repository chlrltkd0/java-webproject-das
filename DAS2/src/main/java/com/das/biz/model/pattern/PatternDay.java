package com.das.biz.model.pattern;

public class PatternDay {
	private int patternId;
	private int dayCode;
	
	public int getPatternId() {
		return patternId;
	}
	public void setPatternId(int patternId) {
		this.patternId = patternId;
	}
	public int getDayCode() {
		return dayCode;
	}
	public void setDayCode(int dayCode) {
		this.dayCode = dayCode;
	}
	public PatternDay(int patternId, int dayCode) {
		super();
		this.patternId = patternId;
		this.dayCode = dayCode;
	}
	public PatternDay() {
		super();
	}
	@Override
	public String toString() {
		return "PatternDay [patternId=" + patternId + ", dayCode=" + dayCode + "]";
	}
}
