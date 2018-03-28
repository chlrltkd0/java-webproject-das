package com.das.biz.model.action.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.analyzer.DayAnalyzer;
import com.das.biz.model.action.ActionService;
import com.das.biz.model.action.Moving;
import com.das.biz.model.action.Staying;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;

@Service
public class ActionServiceImpl implements ActionService {
	
	@Autowired
	private PartyService pService;
	@Autowired
	private ActionDAO actionDAO;
	@Autowired
	private DayAnalyzer dAnalyzer;

	@Override
	public int insertMovingList(PartyVO pvo, List<Moving> moving) {
		return actionDAO.insertMovingList(pvo, moving);
	}

	@Override
	public int insertStayingList(PartyVO pvo, List<Staying> staying) {
		return actionDAO.insertStayingList(pvo, staying);
	}

	@Override
	public List<Moving> getMovingList(PartyVO pvo, Date startDate, Date endDate) {
		return actionDAO.getMovingList(pvo, startDate, endDate);
	}

	@Override
	public List<Staying> getStayingList(PartyVO pvo, Date startDate, Date endDate) {
		return actionDAO.getStayingList(pvo, startDate, endDate);
	}

	@Override
	public int genId() {
		return actionDAO.genId();
	}

	@Override
	public List<Moving> getDayPath(PartyVO pvo, Date startDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, 1);
		Date endDate = new Date(cal.getTime().getTime());
		return actionDAO.getMovingWithStayingList(pvo, startDate, endDate);
	}
	
	@Override
	public List<Moving> getMovingWithStayingList(PartyVO pvo, Date startDate, Date endDate) {
		return actionDAO.getMovingWithStayingList(pvo, startDate, endDate);
	}

	@Override
	public void dayAnalysis(int targetId, PartyVO pvo, Date date) {
		if(pvo.getGrade() >= 10) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			Date endDate = new Date(cal.getTime().getTime());
			dAnalyzer.dayAnalysis(new PartyVO(targetId), date, endDate);
		}
	}

	@Override
	public void dayAnalysisAll(PartyVO pvo, Date date) {
		if(pvo.getGrade() >= 10) {
			for(PartyVO target : pService.getAllPartyList()) {
				dayAnalysis(target.getId(), pvo, date);
			}
		}

		
	}

}
