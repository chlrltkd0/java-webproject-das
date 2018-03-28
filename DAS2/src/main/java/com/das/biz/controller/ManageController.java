package com.das.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.biz.model.delivery.DeliveryService;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.push.PushData;
import com.das.biz.model.push.impl.MyPushService;
import com.das.biz.model.push.impl.PushAlarmServer;

@Controller
public class ManageController {
	
	@Autowired
	MyPushService mpService;
	@Autowired
	DeliveryService dService;
	@Autowired
	PushAlarmServer paserver;
	
	@RequestMapping("setPushData.do")
	@ResponseBody
	public void setPushData(PushData pd, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		mpService.insertPushData(pd, pvo);
	}
	
	@RequestMapping("push.do")
	@ResponseBody
	public void push(PartyVO pvo, HttpSession session) {
		PartyVO myPVO = (PartyVO)session.getAttribute("party");
		mpService.pushSend(pvo, myPVO);
	}
	
	@RequestMapping("pushServiceStart.do")
	@ResponseBody
	public void pushAlarmStart() {
		paserver.start();
	}
}
