package com.das.biz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.biz.model.chatting.ChattingService;
import com.das.biz.model.chatting.ChattingVO;
import com.das.biz.model.party.PartyVO;

@Controller
public class ChattingController {
	
	@Autowired
	private ChattingService cService;
	
	@RequestMapping("chat.do")
	@ResponseBody
	public boolean insertChat(ChattingVO cvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return cService.insertChatting(cvo, pvo);
		
	}
	
	@RequestMapping("getchatlist.do")
	@ResponseBody
	public List<ChattingVO> getChatList(ChattingVO cvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return cService.getChattingList(cvo, pvo);
		
	}
}
