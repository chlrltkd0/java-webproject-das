package com.das.biz.model.chart;

import java.util.List;

import com.das.biz.model.party.PartyVO;

public interface ChartService {
	List<ChartVO> getSales(StartEndDateVO sedvo, PartyVO pvo);
	List<ChartVO> getLocationRanking(PartyVO pvo, int range);
	List<ChartVO> getDeliveryVolume(PartyVO pvo, int option);
	
}
