package com.das.analyzer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.das.biz.model.geo.GeoService;
import com.das.biz.model.party.PartyService;
import com.das.biz.model.party.PartyVO;
import com.das.biz.model.path.PartyLocationVO;
import com.das.biz.model.path.PatternLink;
import com.das.biz.model.path.PatternNode;
import com.das.biz.model.path.PatternService;

@Component
public class MoveAnalyzer {
	
	@Autowired
	private PartyService pService;
	@Autowired
	private GeoService gService;
	@Autowired
	private PatternService ptService;
	
	public void doAnalysis() {
		Calendar startDate = Calendar.getInstance();
		startDate.set(2016, 0, 1, 0, 0);
		List<PartyVO> listParty = pService.getAllPartyList();
		
		for (PartyVO target : listParty) {
			Date sd = new Date(10);
			Date ed = new Date(System.currentTimeMillis());
			target.setListLoc(ptService.getPartyLocationList(target, sd, ed));
			target.setListNode(ptService.getPatternNodeList(target));
			target.setListLink(ptService.getPatternLinkList(target));
			System.out.println(target);
			List<PatternNode> seqNodeList = new ArrayList<>();
			List<PatternNode> newNodeList = new ArrayList<>();
			List<PatternNode> updateNodeList = new ArrayList<>();
			
			PatternNode tempNode = null;
			int newCount = 0;
			for(PartyLocationVO pl : target.getListLoc()) {
				PatternNode node = vicinityNode(target.getListNode(), pl);
				//문제점 : 일단 기존에 있던 Node에 잠깐이라도 지나치면 그노드의 위치가 조금변경됨, 이걸 어케할지 비즈니스 로직적으로 생각.. 그리고 소스가 더러움.. 
				if(node!=null) {
					node = mergeNode(node, pl);
					node.setLocWeight(node.getLocWeight()+1);
					updateNodeList.add(node);
					if(seqNodeList.size()==0 || !seqNodeList.get(seqNodeList.size()-1).equals(node)) seqNodeList.add(node);
					tempNode = null;
				} else if(tempNode!=null && tempNode.isVicinity(pl)) {
					mergeNode(tempNode, pl);
					if(++newCount>5) {
						tempNode.setId(ptService.genId());
						tempNode.setPartyId(target.getId());
						tempNode.setLocation(gService.getAddress(tempNode.getLocation()));
						tempNode.setLocWeight(newCount);
						newNodeList.add(tempNode);
						seqNodeList.add(tempNode);
						target.getListNode().add(tempNode);
						tempNode = null;
						newCount = 0;
					}
				} else {
					tempNode = new PatternNode(pl.getLocation().getLatitude(), pl.getLocation().getLongitude());
				}
			}
			
			List<PatternLink> newLinkList = createPatternLink(seqNodeList, target);
//			System.out.println(seqNodeList);
//			System.out.println(newNodeList);
//			System.out.println(updateNodeList);
//			System.out.println(newLinkList);
			ptService.updatePatternNodeList(updateNodeList);
			ptService.insertPatternNodeList(newNodeList);
			ptService.insertPatternLinkList(newLinkList);
		}
	}
	
	public PatternNode vicinityNode(List<PatternNode> list, PartyLocationVO plvo) {
		for(PatternNode pn : list) {
			if(pn.getLocation().isVicinity(plvo.getLocation()))
				return pn;
		}
		return null;
	}
	
	public boolean isContainSameLink(List<PatternLink> list, PatternLink newpl) {
		for(PatternLink pl : list) {
			if(pl.isEqualPath(newpl))
				return true;
		}
		return false;
	}
	
	public List<PatternLink> createPatternLink(List<PatternNode> nodeList, PartyVO target){
		List<PatternLink> linkList = new ArrayList<>();
		for(int i=0; i<nodeList.size()-1; i++) {
			PatternLink pl = new PatternLink(nodeList.get(i).getId(), nodeList.get(i+1).getId());
			if(!isContainSameLink(target.getListLink(), pl) && pl.getFromNodeId()!=pl.getToNodeId()) {
				pl.setId(ptService.genId());
				pl.setPartyId(target.getId());
				linkList.add(pl);
				target.getListLink().add(pl);
			}
		}
		return linkList;
	}
	
	public PatternNode mergeNode(PatternNode pn, PartyLocationVO plvo) {
		
		double newLatitude = (pn.getLocWeight()*pn.getLocation().getLatitude() + plvo.getLocation().getLatitude())/(pn.getLocWeight()+1);
		double newLongitude = (pn.getLocWeight()*pn.getLocation().getLongitude() + plvo.getLocation().getLongitude())/(pn.getLocWeight()+1);
		pn.getLocation().setLatitude(newLatitude);
		pn.getLocation().setLongitude(newLongitude);
		
		return pn;
	}
}
