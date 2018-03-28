package com.das.biz.model.pattern;

import java.util.List;

import com.das.biz.model.party.PartyVO;

public interface PatternService {
	boolean patternAnalysisAll(PartyVO pvo, int range);
	List<Pattern> getPatternList(PartyVO target);
	List<Pattern> getRangePatternList(PartyVO target, int range);
	int genId();
}
