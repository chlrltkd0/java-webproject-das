package com.das.biz.model.chatting;

import java.util.List;

import com.das.biz.model.party.PartyVO;

public interface ChattingService {
	boolean insertChatting(ChattingVO cvo,PartyVO pvo);
	List<ChattingVO> getChattingList(ChattingVO cvo, PartyVO pvo);
}
