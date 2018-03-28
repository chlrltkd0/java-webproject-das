package com.das.analyzer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.das.biz.model.action.Action;
import com.das.biz.model.action.ActionService;
import com.das.biz.model.action.Moving;
import com.das.biz.model.action.Staying;
import com.das.biz.model.geo.GeoService;
import com.das.biz.model.location.LocationVO;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.path.PartyLocationService;
import com.das.biz.model.path.PartyLocationVO;

@Component
public class DayAnalyzer {
	
	@Autowired
	PartyLocationService plService;
	@Autowired
	ActionService aService;
	@Autowired
	GeoService gService;
	
	static final int MOVING_STANDARDS = 4;
	
	public void dayAnalysis(PartyVO pvo, Date startDate, Date endDate) {

		pvo.setListLoc(plService.getPartyLocationList(pvo, startDate, endDate));
		List<Moving> todayMovingList = new ArrayList<>();
		List<Staying> todayStayingList = new ArrayList<>();
		List<Action> todayActionList;
		
		todayActionList = createActionList(pvo.getListLoc());
		createMovingStayingList(todayActionList, todayMovingList, todayStayingList);
		
		if(todayMovingList.size()!=0)
			aService.insertMovingList(pvo, todayMovingList);
		if(todayStayingList.size()!=0)
			aService.insertStayingList(pvo, todayStayingList);
	}
	
	private void createMovingStayingList(List<Action> al, List<Moving> ml, List<Staying> sl) {
		Moving moving = null;
		for(Action action : al) {
			if(action.getLocationSize() > MOVING_STANDARDS) {
				if(moving!=null) {
					moving = null;
				}
				Staying staying = new Staying();
				staying.setId(aService.genId());
				staying.setLocation(gService.getAddress(new LocationVO(action.getLatitude(), action.getLongitude())));
				staying.setLocationList(action.getLocationList());
				sl.add(staying);
				if(ml.size()!=0){
					ml.get(ml.size()-1).setToStaying(staying);;
				}
			} else {
				if(moving==null) {
					moving = new Moving();
					moving.setId(aService.genId());
					ml.add(moving);
					if(sl.size()!=0)
						moving.setFromStaying(sl.get(sl.size()-1));
				}
				moving.addLocationList(action.getLocationList());
			}
		}
	}
	
	private List<Action> createActionList(List<PartyLocationVO> list){
		List<Action> actionList = new ArrayList<>();
		Action action = null;
		for(PartyLocationVO plvo : list) {
			if(action!=null && action.isVicinity(plvo)) {
				action.addLocation(plvo);
			} else {
				action = new Action();
				actionList.add(action);
				action.addLocation(plvo);
			}
		}
		return actionList;
	}
}
