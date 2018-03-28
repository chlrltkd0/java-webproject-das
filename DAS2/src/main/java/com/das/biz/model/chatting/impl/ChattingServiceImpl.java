package com.das.biz.model.chatting.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.chatting.ChattingService;
import com.das.biz.model.chatting.ChattingVO;
import com.das.biz.model.delivery.DeliveryVO;
import com.das.biz.model.delivery.impl.DeliveryDAO;
import com.das.biz.model.party.PartyVO;

@Service
public class ChattingServiceImpl implements ChattingService{

	@Autowired
	private ChattingDAO chattingDAO;
	@Autowired
	private DeliveryDAO deliveryDAO;
	
	@Override
	public boolean insertChatting(ChattingVO cvo, PartyVO pvo) {
		boolean result = false;
		//이렇게 까지 해야하나? 근데 이렇게 안하면 다른새끼가 대화를 훔쳐볼수가 있음..
		DeliveryVO dvo = new DeliveryVO();
		dvo.setId(cvo.getDeliveryId());
		dvo = deliveryDAO.getDelivery(dvo);
		
		if(dvo.getDelivererId() == pvo.getId() || dvo.getSenderId()==pvo.getId() || dvo.getReceiverId()==pvo.getId()) {
			cvo.setPartyId(pvo.getId());
			result = chattingDAO.insertChattingVO(cvo)==0 ? false : true;
		}
		return result;
	}

	@Override
	public List<ChattingVO> getChattingList(ChattingVO cvo, PartyVO pvo) {
		List<ChattingVO> retChatList = null;
		DeliveryVO dvo = new DeliveryVO();
		dvo.setId(cvo.getDeliveryId());
		dvo = deliveryDAO.getDelivery(dvo);
		
		if(dvo.getDelivererId() == pvo.getId() || dvo.getSenderId()==pvo.getId() || dvo.getReceiverId()==pvo.getId()) {
			retChatList = chattingDAO.getChattingList(cvo);
		}
		return retChatList;
	}
	

}
