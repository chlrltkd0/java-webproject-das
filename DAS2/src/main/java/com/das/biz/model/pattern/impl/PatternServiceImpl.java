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
