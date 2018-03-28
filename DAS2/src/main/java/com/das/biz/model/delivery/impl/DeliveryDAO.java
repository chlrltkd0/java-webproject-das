package com.das.biz.model.delivery.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.delivery.DeliveryImgVO;
import com.das.biz.model.delivery.DeliverySearchOption;
import com.das.biz.model.delivery.DeliveryVO;
import com.das.biz.model.delivery.ReceivingVO;
import com.das.biz.model.delivery.SendingVO;
import com.das.biz.model.party.PartyVO;

@Repository
public class DeliveryDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int genId() {
		return mybatis.selectOne("DeliveryDAO.nextVal");
	}
	
	public int insertDelivery(DeliveryVO dvo) {
		return mybatis.insert("DeliveryDAO.insertDelivery", dvo);
	}
	
	public int deleteDelivery(DeliveryVO dvo) {
		return mybatis.delete("DeliveryDAO.deleteDelivery", dvo);
	}
	
	public int updateDelivery(DeliveryVO dvo) {
		return mybatis.update("DeliveryDAO.updateDelivery", dvo);
	}
	
	public int updateDelivererId(DeliveryVO dvo) {
		return mybatis.update("DeliveryDAO.updateDelivererId", dvo);
	}
	
	public void insertDeliveryImg(DeliveryImgVO divo) {
		mybatis.insert("DeliveryDAO.insertDeliveryImg", divo);
	}
	
	public DeliveryImgVO getDeliveryImg(DeliveryVO dvo) {
		return mybatis.selectOne("DeliveryDAO.getDeliveryImg", dvo);
	}
	
	public DeliveryVO getDelivery(DeliveryVO dvo) {
		return mybatis.selectOne("DeliveryDAO.getDelivery", dvo);
	}
	
	public DeliveryVO getDeliveryBeforeSelectDelivererBySender(DeliveryVO dvo) {
		return mybatis.selectOne("DeliveryDAO.getDeliveryBeforeSelectDelivererBySender", dvo);
	}
	
	public DeliveryVO getDeliveryBeforeSelectDelivererByDeliverer(DeliveryVO dvo) {
		return mybatis.selectOne("DeliveryDAO.getDeliveryBeforeSelectDelivererByDeliverer", dvo);
	}
	
	public DeliveryVO getDeliveryWithRS(DeliveryVO dvo) {
		return mybatis.selectOne("DeliveryDAO.getDeliveryWithRS", dvo);
	}
	
	public List<DeliveryVO> getDeliveryList(DeliverySearchOption dso){
		return mybatis.selectList("DeliveryDAO.getDeliveryList", dso);
	}
	
	public List<DeliveryVO> getDeliveryListForDelivery(DeliverySearchOption dso) {
		return mybatis.selectList("DeliveryDAO.getDeliveryListForDelivery", dso);
	}	
	
	public List<DeliveryVO> getDeliveryListForWaitDeliverer(PartyVO pvo) {
		return mybatis.selectList("DeliveryDAO.getDeliveryListForWaitDeliverer", pvo);
	}
	
	public List<DeliveryVO> getDeliveryInMyPattern(PartyVO pvo) {
		return mybatis.selectList("DeliveryDAO.getDeliveryInMyPattern", pvo);
	}
	
	public List<PartyVO> getPartyListInDeliveryRange(DeliveryVO dvo){
		return mybatis.selectList("DeliveryDAO.getPartyListInDeliveryRange", dvo); 
	}
	
	public int insertDelivererApplication(DeliveryVO dvo) {
		return mybatis.insert("DeliveryDAO.insertDelivererApplication", dvo);
	}
	
	public int insertSending(DeliveryVO dvo) {
		return mybatis.insert("DeliveryDAO.insertSending", dvo);
	}
	
	public int insertReceiving(DeliveryVO dvo) {
		return mybatis.insert("DeliveryDAO.insertReceiving", dvo);
	}
	
	public SendingVO getSending(DeliveryVO dvo) {
		return mybatis.selectOne("DeliveryDAO.getSending", dvo);
	}
	
	public ReceivingVO getReceiving(SendingVO svo) {
		return mybatis.selectOne("DeliveryDAO.getReceiving", svo);
	}
	
	public int confirmSendingForSender(DeliveryVO dvo) {
		return mybatis.update("DeliveryDAO.confirmSendingForSender", dvo);
	}
	public int confirmSendingForDeliverer(DeliveryVO dvo) {
		return mybatis.update("DeliveryDAO.confirmSendingForDeliverer", dvo);
	}
	public int confirmReceivingForDeliverer(DeliveryVO dvo) {
		return mybatis.update("DeliveryDAO.confirmReceivingForDeliverer", dvo);
	}
	public int confirmReceivingForReceiver(DeliveryVO dvo) {
		return mybatis.update("DeliveryDAO.confirmReceivingForReceiver", dvo);
	}
}
