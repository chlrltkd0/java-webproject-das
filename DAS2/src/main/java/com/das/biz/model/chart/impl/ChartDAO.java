package com.das.biz.model.chart.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.chart.ChartVO;
import com.das.biz.model.chart.StartEndDateVO;

@Repository
public class ChartDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<ChartVO> getDeliveryVolume(String option){
		return mybatis.selectList("ChartDAO.getDeliveryVolume", option);
	}

	public List<ChartVO> getSales(StartEndDateVO sedvo) {
		return mybatis.selectList("ChartDAO.getSales", sedvo);
	}

	public List<ChartVO> LocationRanking(int range) {
		return mybatis.selectList("ChartDAO.getLocationRanking", range);
	}

}
