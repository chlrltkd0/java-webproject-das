package com.das.biz.model.pattern.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.party.PartyVO;
import com.das.biz.model.pattern.Pattern;
import com.das.biz.model.pattern.PatternDay;

@Repository
public class PatternDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<Pattern> getPatternList(PartyVO pvo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("partyId", pvo.getId());
		return mybatis.selectList("PatternDAO.getPatternList", paramMap);
	}
	
	public boolean insertPatternList(List<Pattern> plist) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("list", plist);
		boolean result = mybatis.insert("PatternDAO.insertPatternList", paramMap)!=0;
		return result;
	}
	
	public boolean deletePatternAll() {
		boolean result = mybatis.delete("PatternDAO.deletePatternAll")!=0;
		return result;
	}
	
	public int genId() {
		return mybatis.selectOne("PatternDAO.genId");
	}

	public void insertPatternDayList(List<PatternDay> patternDayList) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("list", patternDayList);
		mybatis.selectOne("PatternDAO.insertPatternDayList", patternDayList);
	}

}
