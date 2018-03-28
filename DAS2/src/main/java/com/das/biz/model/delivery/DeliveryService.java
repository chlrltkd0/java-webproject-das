package com.das.biz.model.delivery;

import java.util.List;
import java.util.Map;

import com.das.biz.model.location.LocationVO;
import com.das.biz.model.party.PartyVO;

public interface DeliveryService {

	boolean insertDelivery(DeliveryVO dvo, PartyVO pvo);
	boolean applyForDeliverer(DeliveryVO dvo, PartyVO pvo);
	DeliveryVO setDeliverer(DeliveryVO dvo, PartyVO pvo);
	boolean completeDelivery(DeliveryVO dvo, PartyVO pvo);
	DeliveryVO getDelivery(DeliveryVO dvo, PartyVO pvo);
	List<DeliveryVO> getDeliveryInMyPattern(PartyVO pvo);
	List<DeliveryVO> getDeliveryList(DeliverySearchOption dso);
	List<DeliveryVO> getDeliveryListForDelivery(DeliverySearchOption dso);
	List<DeliveryVO> getDeliveryListForWaitDeliverer(PartyVO pvo);
	List<PartyVO> getPartyListInDeliveryRange(DeliveryVO dvo);
	SendingVO getSending(DeliveryVO dvo);
	ReceivingVO getReceiving(SendingVO svo);
	boolean confirmSendingForSender(DeliveryVO dvo, PartyVO pvo);
	boolean confirmSendingForDeliverer(DeliveryVO dvo, PartyVO pvo);
	boolean confirmReceivingForDeliverer(DeliveryVO dvo, PartyVO pvo);
	boolean confirmReceivingForReceiver(DeliveryVO dvo, PartyVO pvo);
	Map<String, LocationVO> getDeliveryCoords(DeliveryVO dvo, PartyVO pvo);
}
