package com.das.biz.model.push.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.das.biz.model.party.PartyVO;
import com.das.biz.model.push.PushData;

import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;
import nl.martijndwars.webpush.Subscription;

@Component
public class MyPushService {

	@Autowired
	private PushDAO pushDAO;

	MyPushService(){
		Security.addProvider(new BouncyCastleProvider());
	}

	public boolean insertPushData(PushData pd, PartyVO pvo) {
		boolean result = false;
		if(pd.getEndPoint() != "" && pd.getP256dh() != "" && pd.getAuth() != "") {
			if(pushDAO.checkPushData(pd)==0) {
				System.out.println("pvo : " + pvo);
				System.out.println("p d : " + pd);
				pd.setPartyId(pvo.getId());
				result = pushDAO.insertPushData(pd)==1;
			}
		}
		return result;
	}

	public void pushSend(PartyVO pvo, PartyVO myPVO) {
		if(myPVO.getGrade() >= 10) {
			push(pvo);
		}
	}

	public void push(PartyVO pvo) {

		Notification notification;
		PushService pushService = new PushService();

		try {
			pushService.setPublicKey("BKNcoyQxATUzyWCaC396ZPnzCTJS-uj6V86FUyJk6Jsu0hL9QZNklfF74yRMWfsLG9d_HwvrOWi1vBJoeZJc42Q");
			pushService.setPrivateKey("kK9-xYz83HoHeQ7bKSpMLo4X848Q6zR4MVUQD4K8w3w");

		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException e1) {
			e1.printStackTrace();
		}

		List<PushData> pdlist = pushDAO.getPushDataList(pvo);

		for(PushData pd : pdlist) {
			Subscription sub = new Subscription();
			sub.endpoint = pd.getEndPoint();
			sub.keys = sub.new Keys();
			sub.keys.p256dh = pd.getP256dh();
			sub.keys.auth = pd.getAuth();
			try {
				notification = new Notification(sub, "주소");
				pushService.send(notification);
			} catch (GeneralSecurityException | IOException | JoseException | ExecutionException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
