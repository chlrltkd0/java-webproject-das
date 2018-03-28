package com.das.biz.model.partylocation.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.location.LocationVO;
import com.das.biz.model.party.PartyAndLocationCMD;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.partylocation.PartyLocationCMD;
import com.das.biz.model.partylocation.PartyLocationService;
import com.das.biz.model.partylocation.PartyLocationVO;

@Service
public class PartyLocationServiceImpl implements PartyLocationService {
	
	@Autowired
	PartyService pService;
	@Autowired
	PartyLocationDAO plDAO;

	@Override
	public List<PartyLocationVO> getPartyLocationList(PartyVO pvo, Date sd, Date ed){
		return plDAO.getPartyLocationList(pvo, sd, ed);
	}
	
	@Override
	public PartyLocationVO getLastPartyLocation(PartyVO pvo) {
		return plDAO.getLastPartyLocation(pvo);
	}

	@Override
	public boolean insertCurLocation(PartyAndLocationCMD pl) {
		PartyVO pvo = new PartyVO();
		pvo.setLoginId(pl.getLoginId());
		pvo.setLoginPwd(pl.getLoginPwd());
		pvo = pService.getParty(pvo);
		List<PartyLocationVO> paramList = new ArrayList<>();
		
		for(PartyLocationCMD plcmd : pl.getPLList()) {
			PartyLocationVO plvo = new PartyLocationVO();
			plvo.setPartyId(pvo.getId());
			plvo.setLocation(new LocationVO(plcmd.getLatitude(), plcmd.getLongitude()));
			plvo.setDetectTime(new Timestamp(plcmd.getDetectTime()));
			paramList.add(plvo);
		}
		boolean result = plDAO.insertLocationList(paramList)!=0;
		return result;
	}
	
	
}
