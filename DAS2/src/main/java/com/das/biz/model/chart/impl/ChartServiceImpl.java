package com.das.biz.model.chart.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.chart.ChartService;
import com.das.biz.model.chart.ChartVO;
import com.das.biz.model.chart.StartEndDateVO;
import com.das.biz.model.party.PartyVO;

@Service
public class ChartServiceImpl implements ChartService {
	
	@Autowired
	ChartDAO chartDAO;

	@Override
	public List<ChartVO> getSales(StartEndDateVO sedvo, PartyVO pvo) {
		List<ChartVO> result = null;
		if(pvo.getGrade()>=10) {
			if(sedvo.getStartDate().compareTo(sedvo.getEndDate())==1) {
				Date tmp = sedvo.getStartDate();
				sedvo.setStartDate(sedvo.getEndDate());
				sedvo.setEndDate(tmp);
			}
			result = chartDAO.getSales(sedvo);
		}
		return result;
	}

	@Override
	public List<ChartVO> getDeliveryVolume(PartyVO pvo, int option) {
		List<ChartVO> result = null;
		if(pvo.getGrade()>=10) {
			String opt;
			if(option==2)
				opt = "MONTH";
			else
				opt = "DAY";
			result = chartDAO.getDeliveryVolume(opt);
		}
		return result;
	}

	@Override
	public List<ChartVO> getLocationRanking(PartyVO pvo, int range) {
		List<ChartVO> result = null;
		if(pvo.getGrade()>=10) {
			result = chartDAO.LocationRanking(range);
		}
		return result;
	}

}
