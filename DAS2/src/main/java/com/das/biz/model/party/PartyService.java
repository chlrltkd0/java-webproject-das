package com.das.biz.model.party;

import java.util.List;

public interface PartyService {
	boolean register(PartyVO pvo);
	boolean deleteParty(PartyVO pvo);
	boolean updateParty(PartyVO pvo);
	boolean checkLoginId(PartyVO pvo);
	boolean plusCash(PartyVO pvo);
	boolean minusCash(PartyVO pvo);
	public boolean plusSecurityDeposit(PartyVO pvo);
	public boolean minusSecurityDeposit(PartyVO pvo);
	PartyVO getParty(PartyVO pvo);
	List<PartyVO> getAllPartyList();
	PartyListVO getPartyInfoList(PartyVO pvo, int page);
	PartyVO getPartyInfo(int id, PartyVO myPvo);
	boolean updatePartyInfo(PartyVO pvo, PartyVO myPvo);
	List<PartyVO> getAllPartyList(PartyVO pvo);
}
