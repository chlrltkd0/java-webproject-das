package com.das.biz.model.party.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.party.PartyListVO;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;

@Service
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyDAO partyDAO;
	
	@Override
	public boolean register(PartyVO pvo) {
		boolean result = false;
		// 중복된 아이디가 없을 경우 아이디 생성
		if(partyDAO.checkLoginId(pvo)==0) {
			int id = partyDAO.genId(); // 연락처를 추가하기위해서 genId를 생성해놨는데 지금 연락처를 잠시 뺴놨음.
			pvo.setId(id);
			if(partyDAO.insertParty(pvo)!=0) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public boolean deleteParty(PartyVO pvo) {
		boolean result = partyDAO.deleteParty(pvo)==1;
		return result;
	}

	@Override
	public boolean updateParty(PartyVO pvo) {
		boolean result = partyDAO.updateParty(pvo)==1;
		return result;
	}

	@Override
	public PartyVO getParty(PartyVO pvo) {
		PartyVO retPVO = partyDAO.getParty(pvo);
		return retPVO;
	}
	
	@Override
	public PartyVO getPartyById(int partyId) {
		PartyVO retPVO = partyDAO.getPartyById(partyId);
		return retPVO;
	}
	
	@Override
	public List<PartyVO> getAllPartyList(PartyVO pvo) {
		if(pvo.getGrade() >= 10) {
			return partyDAO.getAllPartyList();
		}
		return null;
	}

	@Override
	public boolean checkLoginId(PartyVO pvo) {
		boolean result = partyDAO.checkLoginId(pvo)==0;
		return result;
	}

	@Override
	public boolean plusCash(PartyVO pvo) {
		boolean result = partyDAO.plusCash(pvo)==1;
		return result;
	}

	@Override
	public boolean minusCash(PartyVO pvo) {
		boolean result = false;
		
		PartyVO checkPVO = partyDAO.getParty(pvo);
		if(checkPVO.getCash() >= pvo.getCash())
			result = partyDAO.minusCash(pvo)==1;
		return result;
	}
	@Override
	public boolean plusSecurityDeposit(PartyVO pvo) {
		boolean result = partyDAO.plusSecurityDeposit(pvo)==1;
		return result;
	}

	@Override
	public boolean minusSecurityDeposit(PartyVO pvo) {
		boolean result = false;
		
		PartyVO checkPVO = partyDAO.getParty(pvo);
		if(checkPVO.getSecurityDeposit() >= pvo.getSecurityDeposit())
			result = partyDAO.minusSecurityDeposit(pvo)==1;
		return result;
	}

	@Override
	public List<PartyVO> getAllPartyList() {
		return partyDAO.getAllPartyList();
	}

	@Override
	public PartyListVO getPartyInfoList(PartyVO pvo, int page) {
		PartyListVO result = null;
		if(pvo.getGrade() >= 10) {
			result = new PartyListVO();
			result.setPartyList(partyDAO.getPartyInfoList((page-1)*10));
			result.setPartyCount(partyDAO.getPartyCount());
		}
		return result;
	}

	@Override
	public PartyVO getPartyInfo(int id, PartyVO myPvo) {
		PartyVO result = null;
		if(myPvo.getGrade() >= 10 || id==myPvo.getId()) {
			result = partyDAO.getPartyById(id);
		}
		return result;
	}

	@Override
	public boolean updatePartyInfo(PartyVO pvo, PartyVO myPvo) {
		boolean result = false;
		if(myPvo.getGrade() >= 10 || pvo.getId()==myPvo.getId()) {
			result = partyDAO.updateParty(pvo)==1;
		}
		return result;
	}

	@Override
	public List<PartyVO> getReceiverList(String word) {
		return partyDAO.getReceiverList(word);
	}

}
