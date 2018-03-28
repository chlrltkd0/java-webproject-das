package com.das.biz.model.board;

import com.das.biz.model.party.PartyVO;

public interface BoardService {
	boolean writeBoard(BoardVO bvo, PartyVO pvo);
	boolean deleteBoard(BoardVO bvo, PartyVO pvo);
	boolean updateBoard(BoardVO bvo, PartyVO pvo);
	BoardVO getBoard(BoardVO bvo, PartyVO pvo);
	BoardListVO getBoardList(BoardListVO bsvo);
}
