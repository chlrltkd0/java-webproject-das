package com.das.biz.model.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.board.BoardListVO;
import com.das.biz.model.board.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int insertBoard(BoardVO bvo) {
		return mybatis.insert("BoardDAO.insertBoard", bvo);
	}

	public int deleteBoard(BoardVO bvo) {
		return mybatis.delete("BoardDAO.deleteBoard", bvo);
	}

	public int updateBoard(BoardVO bvo) {
		return mybatis.update("BoardDAO.updateBoard", bvo);
	}

	public BoardVO getBoard(BoardVO bvo) {
		return mybatis.selectOne("BoardDAO.getBoard", bvo);
	}
	
	public int getBoardCount(BoardListVO blvo) {
		return mybatis.selectOne("BoardDAO.getBoardCount", blvo);
	}

	public List<BoardVO> getBoardList(BoardListVO blvo) {
		return mybatis.selectList("BoardDAO.getBoardList", blvo);
	}
}