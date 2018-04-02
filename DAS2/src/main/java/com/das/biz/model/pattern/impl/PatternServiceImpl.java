package com.das.biz.model.pattern.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.analyzer.PatternAnalyzer;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.pattern.Pattern;
import com.das.biz.model.pattern.PatternDay;
import com.das.biz.model.pattern.PatternService;

@Service
public class PatternServiceImpl implements PatternService {

	@Autowired
	PartyService pService;
	@Autowired
	PatternAnalyzer pAnalyzer;
	@Autowired
	PatternDAO pDAO;
	
	@Override
	public boolean patternAnalysisAll(PartyVO pvo, int range) {
		if(pvo.getGrade()>=10) {
			List<Pattern> patternList = new ArrayList<>();
			for(PartyVO target : pService.getAllPartyList()) {
				patternList.addAll(getRangePatternList(target, range));
			}
			List<PatternDay> patternDayList = new ArrayList<>();
			//수정해야함 2번 일을하고있음 분석기에서 0123456를 월화수목금토일 로바꿔놓고 다시 바꾸는중 이거 구조자체를 바꿔야됨 Repeat분석기 구조가 잘못됨
			for(Pattern pattern : patternList) {
				for(String string : pattern.getRepeatList()) {
					if(string.equals("일"))
						patternDayList.add(new PatternDay(pattern.getId(), 0));
					else if(string.equals("월"))
						patternDayList.add(new PatternDay(pattern.getId(), 1));
					else if(string.equals("화"))
						patternDayList.add(new PatternDay(pattern.getId(), 2));
					else if(string.equals("수"))
						patternDayList.add(new PatternDay(pattern.getId(), 3));
					else if(string.equals("목"))
						patternDayList.add(new PatternDay(pattern.getId(), 4));
					else if(string.equals("금"))
						patternDayList.add(new PatternDay(pattern.getId(), 5));
					else if(string.equals("토"))
						patternDayList.add(new PatternDay(pattern.getId(), 6));
				}
			}
			pDAO.insertPatternDayList(patternDayList);
			return pDAO.insertPatternList(patternList);
		}
		return false;
	}
	
	@Override
	public List<Pattern> getPatternList(PartyVO target) {
		return pDAO.getPatternList(target);
	}
	
	@Override
	public List<Pattern> getRangePatternList(PartyVO target, int range) { 
		Date endDate = new Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.add(Calendar.DATE, -range);
		Date startDate = new Date(cal.getTime().getTime());
		return pAnalyzer.analysis(target, startDate, endDate);
	}
	
	@Override
	public int genId() {
		return pDAO.genId();
	}
}
