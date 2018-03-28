package com.das.biz.model.path.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.analyzer.MoveAnalyzer;
import com.das.analyzer.PatternAnalyzer;
import com.das.biz.commandobject.InsertPatternCMD;
import com.das.biz.model.geo.GeoService;
import com.das.biz.model.location.LocationVO;
import com.das.biz.model.party.PartyAndLocationCMD;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.path.PartyLocationCMD;
import com.das.biz.model.path.PartyLocationVO;
import com.das.biz.model.path.PatternLink;
import com.das.biz.model.path.PatternNode;
import com.das.biz.model.path.PatternService;
import com.das.biz.model.pattern.Pattern;

@Service
public class PatternServiceImpl implements PatternService {
	
	@Autowired
	private PatternNodeDAO nodeDAO;
	@Autowired
	private PatternLinkDAO linkDAO;
	@Autowired
	private PartyLocationDAO partylocationDAO;
	@Autowired
	private GeoService gService; 
	@Autowired
	MoveAnalyzer moveAnalyzer;
	@Autowired
	PatternAnalyzer pAnalyzer;
	@Autowired
	PartyService pService;

	@Override
	public boolean insertPattern(InsertPatternCMD ipCMD, PartyVO pvo) {
		int fromNodeId = nodeDAO.genId();
		int toNodeId = nodeDAO.genId();
		int linkId = nodeDAO.genId();
		
		LocationVO fromAlvo = gService.getLocation(new LocationVO("대한민국 " + ipCMD.getFromAddress()));
		LocationVO toAlvo = gService.getLocation(new LocationVO("대한민국 " + ipCMD.getToAddress()));
		
		PatternNode fromNode = new PatternNode(fromNodeId, fromAlvo);
		PatternNode toNode = new PatternNode(toNodeId, toAlvo);
		PatternLink link = new PatternLink(linkId, fromNodeId, toNodeId); 
		
		fromNode.setPartyId(pvo.getId());
		toNode.setPartyId(pvo.getId());
		link.setPartyId(pvo.getId());
		
		boolean ret1 = nodeDAO.insertPatternNode(fromNode)==0 ? false : true;
		boolean ret2 = nodeDAO.insertPatternNode(toNode)==0 ? false : true;
		boolean ret3 = linkDAO.insertPatternLink(link)==0 ? false : true;
		
		return ret1 && ret2 && ret3;
	}

	@Override
	public List<PatternLink> getPatternWithNodeList(PartyVO pvo) {
		return linkDAO.getPatternWithNodeList(pvo.getId());
	}
	
	@Override
	public boolean moveGenerate(PartyVO pvo, int pid) {
		if(pvo.getGrade()>=10) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean anlaysis(PartyVO pvo) {
		if(pvo.getGrade()>=10) {
			moveAnalyzer.doAnalysis();
			return true;
		}
		return true;
	}
	
	@Override
	public List<PartyLocationVO> getPartyLocationList(PartyVO pvo, Date sd, Date ed){
		return partylocationDAO.getPartyLocationList(pvo, sd, ed);
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
		boolean result = partylocationDAO.insertLocationList(paramList)!=0;
		return result;
	}

	@Override
	public List<PatternNode> getPatternNodeList(PartyVO target) {
		return nodeDAO.getPatternNodeList(target.getId());
	}

	@Override
	public List<PatternLink> getPatternLinkList(PartyVO target) {
		return linkDAO.getPatternLinkList(target.getId());
	}

	@Override
	public boolean insertPatternLinkList(List<PatternLink> newLinkList) {
		boolean result = true;
		for(PatternLink link : newLinkList) {
			result = linkDAO.insertPatternLink(link)==1 && result;
		}
		return result;
	}

	@Override
	public boolean updatePatternNodeList(List<PatternNode> updateNodeList) {
		boolean result = true;
		for(PatternNode node : updateNodeList) {
			result = nodeDAO.updatePatternNode(node)==1 && result;
		}
		return result;
	}

	@Override
	public boolean insertPatternNodeList(List<PatternNode> newNodeList) {
		boolean result = true;
		for(PatternNode node : newNodeList) {
			result = nodeDAO.insertPatternNode(node)==1 && result;
		}
		return result;
	}

	@Override
	public int genId() {
		return nodeDAO.genId();
	}

	@Override
	public List<Pattern> getPatternList(PartyVO target, int range) {
		Date endDate = new Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.add(Calendar.DATE, -range);
		Date startDate = new Date(cal.getTime().getTime());
		return pAnalyzer.analysis(target, startDate, endDate);
	}

}
