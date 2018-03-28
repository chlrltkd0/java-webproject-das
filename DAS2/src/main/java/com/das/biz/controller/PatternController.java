package com.das.biz.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.biz.commandobject.InsertPatternCMD;
import com.das.biz.model.action.ActionService;
import com.das.biz.model.party.PartyAndLocationCMD;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.path.PatternLink;
import com.das.biz.model.path.PatternService;
import com.das.biz.model.pattern.Pattern;

@Controller
public class PatternController {
	
	@Autowired
	PatternService pService;
	@Autowired
	PartyService paService;
	@Autowired
	ActionService aService;
	
	@RequestMapping("insertLocation.do")
	@ResponseBody
	public boolean insertLocation(@RequestBody PartyAndLocationCMD pl, HttpSession session) {
		return pService.insertCurLocation(pl);
	}
	
	@RequestMapping("getPatternList.do")
	@ResponseBody
	public List<Pattern> getPatternList(@RequestParam(value="range")int range, PartyVO target, HttpSession session){
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return pService.getPatternList(pvo, range);
	}
	
	@RequestMapping("patternlist.do")
	@ResponseBody
	public List<PatternLink> myMovePattern(HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return pService.getPatternWithNodeList(pvo);
	}

	@RequestMapping("addPattern.do")
	@ResponseBody
	public boolean insertPatternProc(InsertPatternCMD ipCMD, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return pService.insertPattern(ipCMD, pvo);
	}
	
	@RequestMapping("moveGenerate.do")
	@ResponseBody
	public boolean moveGenerate(PartyVO pvo, HttpSession session) {
		PartyVO paramPVO = (PartyVO)session.getAttribute("party");
		return pService.moveGenerate(paramPVO, pvo.getId());
	}
	
	@RequestMapping("analysis.do")
	@ResponseBody
	public void anlaysis(
			@RequestParam(value="partyId")int targetId,
			@RequestParam(value="date")Date date, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		aService.dayAnalysis(targetId, pvo, date);
	}
}
