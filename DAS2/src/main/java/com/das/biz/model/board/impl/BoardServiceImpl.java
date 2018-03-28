package com.das.biz.model.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.board.BoardListVO;
import com.das.biz.model.board.BoardService;
import com.das.biz.model.board.BoardVO;
import com.das.biz.model.party.PartyVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public boolean writeBoard(BoardVO bvo, PartyVO pvo) {
		bvo.setWriter(pvo.getName());
		bvo.setWriterIdx(pvo.getId());
		boolean result = boardDAO.insertBoard(bvo)==1;
		return result;	
	}

	@Override
	public boolean deleteBoard(BoardVO bvo, PartyVO pvo) {
		bvo.setWriterIdx(pvo.getId());
		boolean result = boardDAO.deleteBoard(bvo)==1;
		return result;
	}

	@Override
	public boolean updateBoard(BoardVO bvo, PartyVO pvo) {
		bvo.setWriterIdx(pvo.getId());
		boolean result = boardDAO.updateBoard(bvo)==1;
		return result;
	}

	@Override
	public BoardVO getBoard(BoardVO bvo, PartyVO pvo) {
		return boardDAO.getBoard(bvo);
	}

	@Override
	public BoardListVO getBoardList(BoardListVO blvo) {
		int temp = blvo.getPage();
		blvo.setPage((temp-1)*10);
		blvo.setBoardCount(boardDAO.getBoardCount(blvo));
		blvo.setBoardList(boardDAO.getBoardList(blvo));
		blvo.setPage(temp);
		return blvo;
	}

}