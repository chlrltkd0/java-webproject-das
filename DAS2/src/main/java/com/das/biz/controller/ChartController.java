package com.das.biz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.biz.model.chart.ChartService;
import com.das.biz.model.chart.ChartVO;
import com.das.biz.model.chart.StartEndDateVO;
import com.das.biz.model.party.PartyVO;

@Controller
public class ChartController {
	
	@Autowired
	ChartService cService;
	
	@RequestMapping("getDeliveryVolume.do")
	@ResponseBody
	public List<ChartVO> getDeliveryVolume(@RequestParam(value="option")int option, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return cService.getDeliveryVolume(pvo, option);
	}
	
	@RequestMapping("getSales.do")
	@ResponseBody
	public List<ChartVO> getSales(StartEndDateVO sedvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return cService.getSales(sedvo, pvo);
	}
	
	@RequestMapping("getLocationRanking.do")
	@ResponseBody
	public List<ChartVO> getLocationRanking(@RequestParam(value="range")int range, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return cService.getLocationRanking(pvo, range);
	}
}
