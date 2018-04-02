package com.das.biz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.biz.model.party.PartyListVO;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;

@Controller
public class PartyController {
	
	@Autowired
	private PartyService pService;
	
	@RequestMapping("register.do")
	@ResponseBody
	public boolean registerProc(PartyVO pvo) {
		return pService.register(pvo);
	}
	
	/**
	 * 로그인 처리 함수
	 * */
	@RequestMapping("login.do")
	@ResponseBody
	public PartyVO login(PartyVO pvo, HttpSession session) {
		PartyVO partyVO = pService.getParty(pvo);
		if(partyVO != null) 
			session.setAttribute("party", partyVO);
		return partyVO;
	}
	
	@RequestMapping("isLogin.do")
	@ResponseBody
	public PartyVO isLogin(HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		if(pvo!=null)
			return pService.getPartyById(pvo.getId());
		return null;
	}
	
	@RequestMapping("logout.do")
	@ResponseBody
	public void logoutProc(HttpSession session) {
		session.invalidate();
	}

	@RequestMapping("checkid.do")
	@ResponseBody
	public boolean checkId(PartyVO pvo) {
		return pService.checkLoginId(pvo);
	}
	
	@RequestMapping("getPartyInfoList.do")
	@ResponseBody
	public PartyListVO getPartyInfoList(@RequestParam(value="page")int page, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return pService.getPartyInfoList(pvo, page);
	}
	
	@RequestMapping("getReceiverList.do")
	@ResponseBody
	public List<PartyVO> getReceiverList(@RequestParam(value="word")String word, HttpSession session) {
//		PartyVO myPvo = (PartyVO)session.getAttribute("party");
		return pService.getReceiverList(word);
	}
	
	@RequestMapping("getPartyInfo.do")
	@ResponseBody
	public PartyVO getPartyInfo(PartyVO pvo, HttpSession session) {
		PartyVO myPvo = (PartyVO)session.getAttribute("party");
		return pService.getPartyInfo(pvo.getId(), myPvo);
	}
	
	@RequestMapping("updatePartyInfo.do")
	@ResponseBody
	public boolean updatePartyInfo(PartyVO pvo, HttpSession session) {
		PartyVO myPvo = (PartyVO)session.getAttribute("party");
		return pService.updatePartyInfo(pvo, myPvo);
	}
}
