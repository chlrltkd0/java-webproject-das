package com.das.biz.model.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.board.BoardCategoryService;
import com.das.biz.model.board.BoardCategoryVO;
import com.das.biz.model.party.PartyVO;

@Service
public class BoardCategoryServiceImpl implements BoardCategoryService {
	
	@Autowired
	private BoardCategoryDAO bcDAO;

	@Override
	public boolean insertBoardCategory(BoardCategoryVO bcvo, PartyVO pvo) {
		boolean result = false;
		if(pvo.getGrade() >= 10) {
			result = bcDAO.insertBoardCategory(bcvo)==1;
		}
		return result;
	}

	@Override
	public boolean deleteBoardCategory(BoardCategoryVO bcvo, PartyVO pvo) {
		boolean result = false;
		if(pvo.getGrade() >= 10) {
			result = bcDAO.deleteBoardCategory(bcvo)==1;
		}
		return result;
	}

	@Override
	public boolean updateBoardCategory(BoardCategoryVO bcvo, PartyVO pvo) {
		boolean result = false;
		if(pvo.getGrade() >= 10) {
			result = bcDAO.updateBoardCategory(bcvo)==1;
		}
		return result;
	}

	@Override
	public List<BoardCategoryVO> getBoardCategoryList() {
		return bcDAO.getBoardCategoryList();
	}

	@Override
	public BoardCategoryVO getBoardCategory(BoardCategoryVO bcvo) {
		return bcDAO.getBoardCategory(bcvo);
	}
	
	
}