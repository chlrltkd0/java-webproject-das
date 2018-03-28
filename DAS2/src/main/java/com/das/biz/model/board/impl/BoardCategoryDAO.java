package com.das.biz.model.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.board.BoardCategoryVO;

@Repository
public class BoardCategoryDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertBoardCategory(BoardCategoryVO bcvo) {
		return mybatis.insert("BoardCategoryDAO.insertBoardCategory", bcvo);
	}

	public int deleteBoardCategory(BoardCategoryVO bcvo) {
		return mybatis.delete("BoardCategoryDAO.deleteBoardCategory", bcvo);
	}

	public int updateBoardCategory(BoardCategoryVO bcvo) {
		return mybatis.update("BoardCategoryDAO.updateBoardCategory", bcvo);
	}
	
	public List<BoardCategoryVO> getBoardCategoryList() {
		return mybatis.selectList("BoardCategoryDAO.getBoardCategoryList");
	}

	public BoardCategoryVO getBoardCategory(BoardCategoryVO bcvo) {
		return mybatis.selectOne("BoardCategoryDAO.getBoardCategory", bcvo);
	}


	
}