package com.das.biz.model.path.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.path.PatternLink;

@Repository
public class PatternLinkDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	@Autowired
	PatternNodeDAO nodeDAO;
	
	public int insertPatternLink(PatternLink pl) {
		return mybatis.insert("PatternLinkDAO.insertPatternLink", pl);
	}
	
	//운영자가 전체 데이터를 분석할 떄
	public List<PatternLink> getPatternLinkList(int partyId) {
		return mybatis.selectList("PatternLinkDAO.getPatternLinkList", partyId);
	}
	
	//개인이 자신의 패턴리스트를 볼때
	public List<PatternLink> getPatternWithNodeList(int partyId){
		return mybatis.selectList("PatternLinkDAO.getPatternWithNodeList", partyId);
	}
}
