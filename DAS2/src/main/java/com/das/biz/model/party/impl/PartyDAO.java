package com.das.biz.model.party.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.party.PartyVO;

@Repository
public class PartyDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int insertParty(PartyVO pvo) {
		return mybatis.insert("PartyDAO.insertParty", pvo);
	}

	public int deleteParty(PartyVO pvo) {
		return mybatis.delete("PartyDAO.deleteParty", pvo);
	}

	public int updateParty(PartyVO pvo) {
		return mybatis.update("PartyDAO.updateParty", pvo);
	}

	public PartyVO getParty(PartyVO pvo) {
		return mybatis.selectOne("PartyDAO.getParty", pvo);
	}
	
	public PartyVO getPartyById(int id) {
		return mybatis.selectOne("PartyDAO.getPartyById", id);
	}

	public int checkLoginId(PartyVO pvo) {
		return mybatis.selectOne("PartyDAO.checkLoginId", pvo);
	}
	
	public int plusCash(PartyVO pvo) {
		return mybatis.update("PartyDAO.plusCash", pvo);
	}
	
	public int minusCash(PartyVO pvo) {
		return mybatis.update("PartyDAO.minusCash", pvo);
	}
	
	public int plusSecurityDeposit(PartyVO pvo) {
		return mybatis.update("PartyDAO.plusSecurityDeposit", pvo);
	}
	
	public int minusSecurityDeposit(PartyVO pvo) {
		return mybatis.update("PartyDAO.minusSecurityDeposit", pvo);
	}
	
	public int genId() {
		return mybatis.selectOne("PartyDAO.genId");
	}

	public List<PartyVO> getAllPartyList() {
		return mybatis.selectList("PartyDAO.getAllPartyList");
	}

	public List<PartyVO> getPartyInfoList(int page) {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("page", page);
		return mybatis.selectList("PartyDAO.getPartyInfoList", paramMap);
	}

	public int getPartyCount() {
		return mybatis.selectOne("PartyDAO.getPartyCount");
	}

	public List<PartyVO> getReceiverList(String word) {
		return mybatis.selectList("PartyDAO.getReceiverList", word);
	}

}
