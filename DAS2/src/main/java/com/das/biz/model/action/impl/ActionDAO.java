package com.das.biz.model.action.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.action.Moving;
import com.das.biz.model.action.Staying;
import com.das.biz.model.party.PartyVO;

@Repository
public class ActionDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertMovingList(PartyVO pvo, List<Moving> movingList) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("partyId", pvo.getId());
		paramMap.put("list", movingList);
		return mybatis.insert("ActionDAO.insertMovingList", paramMap);
	}
	public int insertStayingList(PartyVO pvo, List<Staying> stayingList) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("partyId", pvo.getId());
		paramMap.put("list", stayingList);
		return mybatis.insert("ActionDAO.insertStayingList", paramMap);
	}
	public List<Moving> getMovingList(PartyVO pvo, Date startDate, Date endDate){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("partyId", pvo.getId());
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		return mybatis.selectList("ActionDAO.getMovingList", paramMap);
	}
	public List<Staying> getStayingList(PartyVO pvo, Date startDate, Date endDate){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("partyId", pvo.getId());
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		return mybatis.selectList("ActionDAO.getStayingList", paramMap);
	}
	public int genId() {
		return mybatis.selectOne("ActionDAO.genId");
	}
	public List<Moving> getMovingWithStayingList(PartyVO pvo, Date sd, Date ed) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("partyId", pvo.getId());
		paramMap.put("startDate", sd);
		paramMap.put("endDate", ed);
		return mybatis.selectList("ActionDAO.getMovingWithStayingList", paramMap);
	}

}
