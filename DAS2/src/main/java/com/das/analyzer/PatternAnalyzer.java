package com.das.analyzer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.das.biz.model.action.ActionService;
import com.das.biz.model.action.Moving;
import com.das.biz.model.geo.GeoService;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.pattern.Pattern;
import com.das.biz.model.pattern.PatternService;

@Component
public class PatternAnalyzer {
	
	static final double range = 0.005;
	
	@Autowired
	ActionService aService;
	@Autowired
	PatternService pService;
	@Autowired
	GeoService gService;
	
	public List<Pattern> analysis(PartyVO pvo, Date startDate, Date endDate) {
		List<Pattern> patternList = new ArrayList<>();
		pvo.setListMoving(aService.getMovingWithStayingList(pvo, startDate, endDate));
		
		for(Moving moving : pvo.getListMoving()) {
			Pattern pattern = includes(patternList, moving);
			if(pattern!=null) {
				pattern.addMoving(moving);
			} else {
				pattern = new Pattern();
				pattern.addMoving(moving);
				patternList.add(pattern);
			}
		}
		
		for(Pattern pattern : patternList) {
			pattern.setRepeatList(new RepeatAnalyzer().getRepeatList(pattern));
			pattern.setRepeatCount(pattern.getMovingList().size());
			pattern.setPartyId(pvo.getId());
			pattern.setFromLocation(gService.getAddress(pattern.getFromLocation()));
			pattern.setToLocation(gService.getAddress(pattern.getToLocation()));
		}
		return patternList;
		
	}
	
	private Pattern includes(List<Pattern> pl, Moving moving) {
		for(Pattern pattern : pl) {
			if(pattern.getFromLocation().isVicinity(moving.getFromStaying().getLocation()) && 
					pattern.getToLocation().isVicinity(moving.getToStaying().getLocation()))
				return pattern;
		}
		return null;
	}
	
	

}
