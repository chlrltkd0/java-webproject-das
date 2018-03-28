package com.das.biz.model.delivery.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.delivery.DeliverySearchOption;
import com.das.biz.model.delivery.DeliveryService;
import com.das.biz.model.delivery.DeliveryVO;
import com.das.biz.model.delivery.ReceivingVO;
import com.das.biz.model.delivery.SendingVO;
import com.das.biz.model.geo.GeoService;
import com.das.biz.model.location.LocationVO;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.partylocation.PartyLocationService;
import com.das.biz.model.push.impl.PushAlarmServer;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	private DeliveryDAO deliveryDAO;
	@Autowired
	private PartyService pService;
	@Autowired
	private GeoService gService;
	@Autowired
	PushAlarmServer paServer;
	@Autowired
	private PartyLocationService plService;
	
	
	public boolean insertDelivery(DeliveryVO dvo, PartyVO pvo) {
		boolean result = false;
		
		PartyVO checkPVO = pService.getParty(pvo);
		
		if(checkPVO.getCash() >= dvo.getChargeAmt())
		{
			checkPVO.setCash(dvo.getChargeAmt());
			pService.minusCash(checkPVO);
			
			int id = deliveryDAO.genId();
			dvo.setId(id);
			
			// Daum과 Google 사이에서 주소처리가 다름.
			dvo.setReceivingLoc("대한민국 " + dvo.getReceivingLoc());
			dvo.setSendingLoc("대한민국 " +dvo.getSendingLoc());		
			/////////////////////////////////////////////// 
			
			dvo.setSenderId(pvo.getId());
			
			LocationVO sendalvo = gService.getLocation(new LocationVO(dvo.getSendingLoc()));
			LocationVO recvalvo = gService.getLocation(new LocationVO(dvo.getReceivingLoc()));
			
			dvo.setSendingLatitude(sendalvo.getLatitude());
			dvo.setSendingLongitude(sendalvo.getLongitude());
			dvo.setReceivingLatitude(recvalvo.getLatitude());
			dvo.setReceivingLongitude(recvalvo.getLongitude());
			
			result = deliveryDAO.insertDelivery(dvo)==1;
			paServer.addDelivery(deliveryDAO.getDelivery(dvo));
		}
		return result;
	}
	@Override
	public boolean applyForDeliverer(DeliveryVO dvo, PartyVO pvo) {
		dvo.setDelivererId(pvo.getId());
		boolean result = deliveryDAO.insertDelivererApplication(dvo)==0;
		return result;
	}
	
	@Override
	public DeliveryVO setDeliverer(DeliveryVO dvo, PartyVO pvo) {
		boolean r1 = false;
		boolean r2 = false;
		DeliveryVO checkDvo = deliveryDAO.getDelivery(dvo);
		
		if(checkDvo.getSenderId() == pvo.getId()) {
			//원래 신청했는지까지 검증을 해야지 정석인것 같음 셀렉트해가지고 deliverId를 갖고있는애가 진짜 신청을했는지 지금은 안하고 넘어감
			if(deliveryDAO.updateDelivererId(dvo)!=0) {
				r1 = deliveryDAO.insertSending(dvo)==0 ? false : true;
				r2 = deliveryDAO.insertReceiving(dvo)==0 ? false : true;
				if(r1 && r2) 
					checkDvo = getDelivery(dvo, pvo);
			}
		}		
		return checkDvo;
	}

	@Override
	public boolean completeDelivery(DeliveryVO dvo, PartyVO pvo) {
		
		return true;
	}

	@Override
	public List<DeliveryVO> getDeliveryList(DeliverySearchOption dso) {
		return deliveryDAO.getDeliveryList(dso);
	}
	
	@Override
	public List<DeliveryVO> getDeliveryListForDelivery(DeliverySearchOption dso){
		return deliveryDAO.getDeliveryListForDelivery(dso);
	}
	
	@Override
	public List<DeliveryVO> getDeliveryListForWaitDeliverer(PartyVO pvo){
		return deliveryDAO.getDeliveryListForWaitDeliverer(pvo);
	}
	
	@Override
	public List<PartyVO> getPartyListInDeliveryRange(DeliveryVO dvo){
		return deliveryDAO.getPartyListInDeliveryRange(dvo);
	}
	
	@Override
	public DeliveryVO getDelivery(DeliveryVO dvo, PartyVO pvo) {
		dvo = deliveryDAO.getDelivery(dvo);
		
		// 로그인을 했을 때
		if(pvo!=null) {
			// 배송자가 정해지지 않았을 경우
			if(dvo.getDelivererId() == 0) {
				// 자신이 발송자일 경우.
				if(dvo.getSenderId() == pvo.getId()) {
					dvo = deliveryDAO.getDeliveryBeforeSelectDelivererBySender(dvo);
				} else {
					dvo.setDelivererId(pvo.getId());
					dvo = deliveryDAO.getDeliveryBeforeSelectDelivererByDeliverer(dvo);
				}
			// 배송자가 정해졌고 내가 발송자 , 배송자, 수령자 중한명일 경우
			} else if(pvo.getId() == dvo.getSenderId() || pvo.getId() == dvo.getDelivererId() || pvo.getId() == dvo.getReceiverId()) {
				dvo = deliveryDAO.getDeliveryWithRS(dvo);
			}
		}
		return dvo;
	}
	
	@Override
	public List<DeliveryVO> getDeliveryInMyPattern(PartyVO pvo) {
		return deliveryDAO.getDeliveryInMyPattern(pvo);
	}

	@Override
	public SendingVO getSending(DeliveryVO dvo) {
		return deliveryDAO.getSending(dvo);
	}

	@Override
	public ReceivingVO getReceiving(SendingVO svo) {
		return deliveryDAO.getReceiving(svo);
	}

	@Override
	public boolean confirmSendingForSender(DeliveryVO dvo, PartyVO pvo) {
		boolean result = false;
		dvo = deliveryDAO.getDelivery(dvo);
		
		if(pvo.getId() == dvo.getSenderId())
			result = deliveryDAO.confirmSendingForSender(dvo) == 1;
		System.out.println(result);
		return result;
	}

	@Override
	public boolean confirmSendingForDeliverer(DeliveryVO dvo, PartyVO pvo) {
		boolean result = false;
		dvo = deliveryDAO.getDelivery(dvo);
		
		if(pvo.getId() == dvo.getDelivererId())
			result = deliveryDAO.confirmSendingForDeliverer(dvo) == 1;
		return result;
	}

	@Override
	public boolean confirmReceivingForDeliverer(DeliveryVO dvo, PartyVO pvo) {
		boolean result = false;
		dvo = deliveryDAO.getDelivery(dvo);
		
		if(pvo.getId() == dvo.getDelivererId())
			result = deliveryDAO.confirmReceivingForDeliverer(dvo) == 1;
		return result;
	}

	@Override
	public boolean confirmReceivingForReceiver(DeliveryVO dvo, PartyVO pvo) {
		boolean result = false;
		dvo = deliveryDAO.getDelivery(dvo);
		
		if(pvo.getId() == dvo.getReceiverId()) {
			result = deliveryDAO.confirmReceivingForReceiver(dvo) == 1;
			if(result == true) {
				
				int cash = (int)Math.round(dvo.getChargeAmt()*0.8d);
				int securityDeposit = (int)Math.round(dvo.getChargeAmt()*0.1d);
				int fees = (int)Math.round(dvo.getChargeAmt()*0.1d);
				
				PartyVO delivererPVO = new PartyVO();
				
				delivererPVO.setId(dvo.getDelivererId());
				delivererPVO.setCash(cash);
				delivererPVO.setSecurityDeposit(securityDeposit);
				
				pService.plusCash(delivererPVO);
				pService.plusSecurityDeposit(delivererPVO);
				
			}
		}
		return result;
	}
	@Override
	public Map<String, LocationVO> getDeliveryCoords(DeliveryVO dvo, PartyVO pvo) {
		Map<String, LocationVO> retMap = new HashMap<>();
		dvo = deliveryDAO.getDeliveryWithRS(dvo);
		if(pvo.getId() == dvo.getSenderId() || pvo.getId() == dvo.getDelivererId() || pvo.getId() == dvo.getReceiverId()) {
			if(dvo.getSendingVO().isSenderConfirm()==false)
				retMap.put("sender", plService.getLastPartyLocation(new PartyVO(dvo.getSenderId())).getLocation());
			if(dvo.getReceivingVO().isReceiverConfirm()==false) {
				retMap.put("deliverer", plService.getLastPartyLocation(new PartyVO(dvo.getDelivererId())).getLocation());
				retMap.put("receiver", plService.getLastPartyLocation(new PartyVO(dvo.getReceiverId())).getLocation());
			}
		}
		return retMap;
	}
}
