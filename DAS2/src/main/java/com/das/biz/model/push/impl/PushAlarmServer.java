package com.das.biz.model.push.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.das.biz.model.delivery.DeliveryVO;

@Component
public class PushAlarmServer {

	@Autowired
	private PushAlarmThread pushAlarmThread;
	
	public void start() {
		pushAlarmThread.start();
	}
	
	public void addDelivery(DeliveryVO dvo) {
		pushAlarmThread.addDelivery(dvo);
	}

}
