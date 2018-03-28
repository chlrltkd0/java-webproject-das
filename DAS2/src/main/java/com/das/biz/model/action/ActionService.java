package com.das.biz.model.action;

import java.sql.Date;
import java.util.List;

import com.das.biz.model.party.PartyVO;

public interface ActionService {
	int insertMovingList(PartyVO pvo, List<Moving> moving);
	int insertStayingList(PartyVO pvo, List<Staying> staying);
	int genId();
	List<Moving> getDayPath(PartyVO pvo, Date date);
	List<Moving> getMovingWithStayingList(PartyVO pvo, Date startDate, Date endDate);
	List<Moving> getMovingList(PartyVO pvo, Date startDate, Date endDate);
	List<Staying> getStayingList(PartyVO pvo, Date startDate, Date endDate);
	void dayAnalysis(int targetId, PartyVO pvo, Date startDate);
	void dayAnalysisAll(PartyVO pvo, Date date);
}
