package com.das.biz.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.biz.model.delivery.DeliverySearchOption;
import com.das.biz.model.delivery.DeliveryService;
import com.das.biz.model.delivery.DeliveryVO;
import com.das.biz.model.location.LocationVO;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.partylocation.PartyLocationService;

@Controller
public class DeliveryController {
	
	@Autowired
	private DeliveryService dService;
	
	@RequestMapping("requestdelivery.do")
	@ResponseBody
	public boolean requestDelivery(DeliveryVO dvo, HttpSession session,
			@RequestParam(value="tmpSendingDt", required=true)long tsendingDt,
			@RequestParam(value="tmpReceivingDt", required=true)long treceivingDt) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		dvo.setSendingDt(new Timestamp(tsendingDt));
		dvo.setReceivingDt(new Timestamp(treceivingDt));
		return dService.insertDelivery(dvo, pvo);
	}
	
	@RequestMapping("delivery.do")
	@ResponseBody
	public DeliveryVO getDelivery(DeliveryVO dvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.getDelivery(dvo, pvo);
	}
	
	@RequestMapping("deliveryInMyPattern.do")
	@ResponseBody
	public List<DeliveryVO> getDeliveryInMyPattern(HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.getDeliveryInMyPattern(pvo);
	}
	
	@RequestMapping("deliverylist.do")
	@ResponseBody
	public List<DeliveryVO> getDeliveryList(DeliverySearchOption dso) {
		return dService.getDeliveryList(dso);
	}
	
	@RequestMapping("deliverylistfordelivery.do")
	@ResponseBody
	public List<DeliveryVO> getDeliveryListForDelivery(DeliverySearchOption dso) {
		return dService.getDeliveryListForDelivery(dso);
	}
	
	@RequestMapping("deliverylistforwaitdeliverer.do")
	@ResponseBody
	public List<DeliveryVO> getDeliveryListForWaitDeliverer(HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.getDeliveryListForWaitDeliverer(pvo);
	}
	
	@RequestMapping("applyForDeliverer.do")
	@ResponseBody
	public boolean applyForDeliverer(DeliveryVO dvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.applyForDeliverer(dvo, pvo);
	}
	
	@RequestMapping("setDeliverer.do")
	@ResponseBody
	public DeliveryVO setDeliverer(DeliveryVO dvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.setDeliverer(dvo, pvo);
	}
	
	@RequestMapping("confirmSendingForSender.do")
	@ResponseBody
	public boolean confirmSendingForSender(DeliveryVO dvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.confirmSendingForSender(dvo, pvo);
	}
	
	@RequestMapping("confirmSendingForDeliverer.do")
	@ResponseBody
	public boolean confirmSendingForDeliver(DeliveryVO dvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.confirmSendingForDeliverer(dvo, pvo);
	}
	
	@RequestMapping("confirmReceivingForDeliverer.do")
	@ResponseBody
	public boolean confirmReceivingForDeliver(DeliveryVO dvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.confirmReceivingForDeliverer(dvo, pvo);
	}
	
	@RequestMapping("confirmReceivingForReceiver.do")
	@ResponseBody
	public boolean confirmReceivingForReceiver(DeliveryVO dvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.confirmReceivingForReceiver(dvo, pvo);
	}
	
	@RequestMapping("getDeliveryCoords.do")
	@ResponseBody
	public Map<String, LocationVO> getDeliveryCoords(DeliveryVO dvo, HttpSession session) {
		PartyVO pvo = (PartyVO)session.getAttribute("party");
		return dService.getDeliveryCoords(dvo, pvo);
	}
}
