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

import com.das.biz.model.action.ActionService;
import com.das.biz.model.party.PartyAndLocationCMD;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.partylocation.PartyLocationService;
import com.das.biz.model.pattern.Pattern;
import com.das.biz.model.pattern.PatternService;

@Controller
public class PatternController {
	
	@Autowired
	PatternService pService;
	@Autowired
	PartyService paService;
	@Autowired
	ActionService aService;
	@Autowired
	PartyLocationService plService;
	
	@RequestMapping("insertLocation.do")
	@ResponseBody
	public boolean insertLocation(@RequestBody PartyAndLocationCMD pl, HttpSession session) {
		return plService.insertCurLocation(pl);
	}
	
	@RequestMapping("getRangePatternList.do")
	@ResponseBody
	public List<Pattern> getRangePatternList(@RequestParam(value="range")int range, PartyVO target, HttpSession session){
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return pService.getRangePatternList(pvo, range);
	}
	
	@RequestMapping("getPatternList.do")
	@ResponseBody
	public List<Pattern> getPatternList(HttpSession session){
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return pService.getPatternList(pvo);
	}

	@RequestMapping("dayAnalysis.do")
	@ResponseBody
	public void dayAnalysis(
			@RequestParam(value="partyId")int targetId,
			@RequestParam(value="date")Date date, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		aService.dayAnalysis(targetId, pvo, date);
	}
	
	@RequestMapping("dayAnalysisAll.do")
	@ResponseBody
	public void dayAnlaysisAll(
			@RequestParam(value="date")Date date, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		aService.dayAnalysisAll(pvo, date);
	}
	
	@RequestMapping("patternAnalysisAll.do")
	@ResponseBody
	public void patternAnlaysisAll(
			@RequestParam(value="range")int range, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		pService.patternAnalysisAll(pvo, range);
	}
}
