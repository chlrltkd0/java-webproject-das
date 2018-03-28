package com.das.biz.model.push.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.das.biz.model.delivery.DeliveryService;
import com.das.biz.model.delivery.DeliveryVO;
import com.das.biz.model.party.PartyVO;

@Component
public class PushAlarmThread extends Thread {
	
	@Autowired
	DeliveryService dService;
	@Autowired
	MyPushService mpService;
	
	private List<DeliveryVO> dlist = new ArrayList<>();
	private List<DeliveryVO> addlist = new ArrayList<>();
	private List<DeliveryVO> removelist = new ArrayList<>();
	
	public void addDelivery(DeliveryVO dvo) {
		addlist.add(dvo);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("While 첫부분 - ");
			try {
				System.out.println("for 문 돌기전 - dlist + " + dlist);
				for(DeliveryVO dvo : dlist) {
					System.out.println("dlist 안에있는 DVO " + dvo);
					System.out.println(dvo.getId() + "번, " + dvo.getGrade() + " 등급에 PUSH");
					if(dvo.getGrade()==-1) {
						removelist.add(dvo);
						System.out.println("delivery의 grade 가 -1이라 continue " + dvo);
						continue;
					}
					List<PartyVO> plist = dService.getPartyListInDeliveryRange(dvo);
					System.out.println("범위안에 있는사람 : " + plist);
					for(PartyVO pvo : plist) {
						mpService.push(pvo);
					}
					dvo.setGrade(dvo.getGrade()-1);
					System.out.println("dvo.grade - 1 = " + dvo);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				dlist.addAll(addlist);
				dlist.removeAll(removelist);
				
				addlist.clear();			
				removelist.clear();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
