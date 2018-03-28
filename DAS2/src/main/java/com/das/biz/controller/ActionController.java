package com.das.biz.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.biz.model.action.ActionService;
import com.das.biz.model.action.Moving;
import com.das.biz.model.party.PartyVO;

@Controller
public class ActionController {
	
	@Autowired
	ActionService aService;
	
	@RequestMapping("getDayPath.do")
	@ResponseBody
	public List<Moving> getDayPath(@RequestParam(value="date")Date date, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return aService.getDayPath(pvo, date);
	}
}
