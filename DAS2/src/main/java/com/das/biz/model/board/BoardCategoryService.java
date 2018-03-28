package com.das.biz.model.board;

import java.util.List;

import com.das.biz.model.party.PartyVO;

public interface BoardCategoryService {
	boolean insertBoardCategory(BoardCategoryVO bcvo, PartyVO pvo);
	boolean deleteBoardCategory(BoardCategoryVO bcvo, PartyVO pvo);
	boolean updateBoardCategory(BoardCategoryVO bcvo, PartyVO pvo);
	List<BoardCategoryVO> getBoardCategoryList();
	BoardCategoryVO getBoardCategory(BoardCategoryVO bcvo);

}
