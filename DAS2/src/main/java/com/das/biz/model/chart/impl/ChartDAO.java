package com.das.biz.model.chart.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.chart.DeliveryVolumeVO;
import com.das.biz.model.chart.StartEndDateVO;

@Repository
public class ChartDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<DeliveryVolumeVO> getDeliveryVolume(StartEndDateVO sedvo){
		return mybatis.selectList("ChartDAO.getDeliveryVolume", sedvo);
	}

}
