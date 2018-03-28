package com.das.analyzer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.das.biz.model.action.ActionService;
import com.das.biz.model.action.Moving;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.pattern.Pattern;

@Component
public class PatternAnalyzer {
	
	static final double range = 0.005;
	
	@Autowired
	private ActionService aService;
	
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
			pattern.setRepeatList();
			pattern.setRepeatCount(pattern.getMovingList().size());
			System.out.println(pattern);
			System.out.println(pattern.getFromLocation().getLatitude() + " : " + pattern.getRepeatList());
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
