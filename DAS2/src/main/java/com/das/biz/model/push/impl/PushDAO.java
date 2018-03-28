package com.das.biz.model.push.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.party.PartyVO;
import com.das.biz.model.push.PushData;

@Repository
public class PushDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public int insertPushData(PushData pd) {
		return mybatis.insert("PushDAO.insertPushData", pd);
	}
	
	public int checkPushData(PushData pd) {
		return mybatis.selectOne("PushDAO.CheckPushData", pd);
	}
	
	public List<PushData> getPushDataList(PartyVO pvo){
		return mybatis.selectList("PushDAO.getPushDataList", pvo);
	}
}
