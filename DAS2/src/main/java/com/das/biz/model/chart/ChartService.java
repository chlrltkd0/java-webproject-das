package com.das.biz.model.chart;

import java.util.List;

import com.das.biz.model.party.PartyVO;

public interface ChartService {
	List<DeliveryVolumeVO> getDeliveryVolume(StartEndDateVO sedvo, PartyVO pvo);
	
}
