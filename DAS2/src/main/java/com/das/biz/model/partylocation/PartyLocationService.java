package com.das.biz.model.partylocation;

import java.sql.Date;
import java.util.List;

import com.das.biz.model.party.PartyAndLocationCMD;
import com.das.biz.model.party.PartyVO;

public interface PartyLocationService {
	List<PartyLocationVO> getPartyLocationList(PartyVO pvo, Date sd, Date ed);
	PartyLocationVO getLastPartyLocation(PartyVO pvo);
	boolean insertCurLocation(PartyAndLocationCMD pl);
}
