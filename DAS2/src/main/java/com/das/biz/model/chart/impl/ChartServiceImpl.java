package com.das.biz.model.chart.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.chart.ChartService;
import com.das.biz.model.chart.DeliveryVolumeVO;
import com.das.biz.model.chart.StartEndDateVO;
import com.das.biz.model.party.PartyVO;

@Service
public class ChartServiceImpl implements ChartService {
	
	@Autowired
	ChartDAO chartDAO;

	@Override
	public List<DeliveryVolumeVO> getDeliveryVolume(StartEndDateVO sedvo, PartyVO pvo) {
		List<DeliveryVolumeVO> result = null;
		if(pvo.getGrade()>=10) {
			if(sedvo.getStartDate().compareTo(sedvo.getEndDate())==1) {
				Date tmp = sedvo.getStartDate();
				sedvo.setStartDate(sedvo.getEndDate());
				sedvo.setEndDate(tmp);
			}
			result = chartDAO.getDeliveryVolume(sedvo);
		}
		return result;
	}

}
