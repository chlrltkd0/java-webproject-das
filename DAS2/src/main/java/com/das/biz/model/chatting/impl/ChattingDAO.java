package com.das.biz.model.chatting.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.chatting.ChattingVO;

@Repository
public class ChattingDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public int insertChattingVO(ChattingVO cvo) {
		return mybatis.insert("ChattingDAO.insertChattingVO", cvo);
	}
	
	public List<ChattingVO> getChattingList(ChattingVO cvo) {
		return mybatis.selectList("ChattingDAO.getChattingList", cvo);
	}

}
