package com.das.biz.model.partylocation.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.party.PartyVO;
import com.das.biz.model.partylocation.PartyLocationVO;

@Repository
public class PartyLocationDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertLocation(PartyLocationVO locVO) {
		mybatis.insert("PartyLocationDAO.insertLocation", locVO);
	}
	
	public int insertLocationList(List<PartyLocationVO> pl) {
		Map<String, List<PartyLocationVO>> map = new HashMap<>();
		map.put("list", pl);
		return mybatis.insert("PartyLocationDAO.insertLocationList", map);
	}

	public List<PartyVO> getLocationList(Date dateCriteria) {
		java.sql.Timestamp dt4Table = new java.sql.Timestamp(dateCriteria.getTime());
		mybatis.update("PartyLocationDAO.targeting", dt4Table);
		List<PartyVO> ret = mybatis.selectList("PartyLocationDAO.getLocationList", dt4Table);

		return ret;
	}

	public List<PartyLocationVO> getPartyLocationList(PartyVO pvo, Date sd, Date ed) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("partyId", pvo.getId());
		paramMap.put("startDate", sd);
		paramMap.put("endDate", ed);
		return mybatis.selectList("PartyLocationDAO.getPartyLocationList", paramMap);
	}

	public PartyLocationVO getLastPartyLocation(PartyVO pvo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("partyId", pvo.getId());
		return mybatis.selectOne("PartyLocationDAO.getLastPartyLocation", paramMap);
	}
}
