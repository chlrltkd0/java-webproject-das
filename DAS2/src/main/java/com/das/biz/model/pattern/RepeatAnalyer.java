package com.das.biz.model.pattern;

import java.util.ArrayList;
import java.util.List;

public class RepeatAnalyer {
	private List<Pair> dayList = new ArrayList<>();
	private List<Pair> dateList = new ArrayList<>();
	private String[] dayMap = new String[] {"", "일", "월", "화", "수", "목", "금", "토"};
	
	public RepeatAnalyer() {
		super();
		for(int i=1; i<dayMap.length; i++) {
			dayList.add(new Pair(dayMap[i], 0));
		}
	}
	
	public void plusDay(int key) {
		Pair pair = this.getPair(dayList, dayMap[key]);
		pair.plusValue();
	}
	public void plusDate(int key) {
		Pair pair = this.getPair(dateList, key+"");
		if(pair==null) {
			pair = new Pair(key+"", 0);
			dateList.add(pair);
		}
		pair.plusValue();
	}
	public List<String> getRepeatStringList(){
		List<String> list = new ArrayList<>();
		
		if(getMaxValue(dayList).getValue() < getMaxValue(dateList).getValue()) {
			list.add(getMaxValue(dateList).getKey());
		} else {
			//일단 철저하게 관리를하고있는데... 나중에 좀더 자세한 비즈니스로직을 생각해내면 수정하면됨
			boolean result = true;
			for(Pair pair : dayList) {
				result = result && (pair.getValue()==getMaxValue(dayList).getValue());
			}
			// 매일인지 검사
			if(result) {
				list.add("매일");
				return list;
			}
			
			String[] weekdays = {"월","화","수","목","금"};
			for(Pair pair : getPairList(dayList, weekdays)) {
				result = result && (pair.getValue()==getMaxValue(dayList).getValue());
			}
			if(result) {
				list.add("주중");
			} else {
				for(Pair pair :getPairList(dayList, weekdays)) {
					if(pair.getValue()==getMaxValue(dayList).getValue()) {
						list.add(pair.getKey());
					}
				}
			}
			
			String[] weekend = {"토","일"};
			for(Pair pair : getPairList(dayList, weekend)) {
				result = result && (pair.getValue()==getMaxValue(dayList).getValue());
			}
			if(result) {
				list.add("주말");
				return list;
			} else {
				for(Pair pair :getPairList(dayList, weekend)) {
					if(pair.getValue()==getMaxValue(dayList).getValue()) {
						list.add(pair.getKey());
					}
				}
			}
		}
		return list;
	}
	public Pair getMaxValue(List<Pair> pl) {
		Pair maxPair = null;
		for(Pair pair :pl) {
			if(maxPair==null || maxPair.compare(pair)==-1) {
				maxPair = pair;
			}
		}
		return maxPair;
	}
	
	public Pair getPair(List<Pair> pl, String key) {
		for(Pair p : pl) {
			if(p.getKey().equals(key))
				return p;
		}
		return null;
	}
	
	public List<Pair> getPairList(List<Pair> pl, String[] keyList) {
		List<Pair> ret = new ArrayList<>();
		
		for(String key : keyList) {
			for(Pair pair : pl) {
				if(pair.getKey().equals(key)) {
					ret.add(pair);
				}
			}
		}
		
		return ret;
	}
	
	public Pair get(List<Pair> pl, String key) {
		for(Pair p : pl) {
			if(p.getKey().equals(key))
				return p;
		}
		return null;
	}
	
	class Pair{
		
		String key;
		Integer value;
		
		public Pair() {
			super();
		}

		public Pair(String key, Integer value) {
			super();
			this.key = key;
			this.value = value;
		}
		
		public void plusValue() {
			this.value += 1;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public int compare(Pair pair) {
			if(value<pair.getValue())
				return -1;
			else if(value==pair.getValue())
				return 0;
			else
				return 1;
			
		}
	}
}
