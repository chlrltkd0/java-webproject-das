package com.das.biz.model.path;

import java.sql.Date;
import java.util.List;

import com.das.biz.commandobject.InsertPatternCMD;
import com.das.biz.model.party.PartyAndLocationCMD;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.pattern.Pattern;

public interface PatternService {
	boolean insertPattern(InsertPatternCMD ipCMD, PartyVO pvo);
	List<PatternLink> getPatternWithNodeList(PartyVO pvo);
	boolean moveGenerate(PartyVO pvo, int pid);
	boolean anlaysis(PartyVO pvo);
	boolean insertCurLocation(PartyAndLocationCMD plcmd);
	List<PartyLocationVO> getPartyLocationList(PartyVO pvo, Date st, Date et);
	List<PatternNode> getPatternNodeList(PartyVO target);
	List<PatternLink> getPatternLinkList(PartyVO target);
	List<Pattern> getPatternList(PartyVO target, int range);
	boolean insertPatternLinkList(List<PatternLink> newLinkList);
	boolean updatePatternNodeList(List<PatternNode> updateNodeList);
	boolean insertPatternNodeList(List<PatternNode> newNodeList);
	int genId();
}
