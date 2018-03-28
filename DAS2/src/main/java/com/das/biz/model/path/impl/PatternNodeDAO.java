package com.das.biz.model.path.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.path.PatternNode;

@Repository
public class PatternNodeDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	
	public int insertPatternNode(PatternNode pn) {
		return mybatis.insert("PatternNodeDAO.insertPatternNode", pn);
	}
	
	public int updatePatternNode(PatternNode pn) {
		return mybatis.insert("PatternNodeDAO.updatePatternNode", pn);
	}

	public List<PatternNode> getPatternNodeList(int partyId) {
		List<PatternNode> ret = mybatis.selectList("PatternNodeDAO.getPatternNodeList", partyId);
		return ret;
	}
	
	public int genId() {
		return mybatis.selectOne("PatternNodeDAO.genId");
	}
}
