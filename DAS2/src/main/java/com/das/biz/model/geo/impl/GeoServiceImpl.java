package com.das.biz.model.geo.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.geo.GeoService;
import com.das.biz.model.location.LocationVO;
import com.das.biz.model.location.impl.LocationDAO;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

@Service
public class GeoServiceImpl implements GeoService {
	
	@Autowired
	LocationDAO alDAO;
	GeoApiContext context;

	public GeoServiceImpl() {
		context = new GeoApiContext.Builder()
				.apiKey("AIzaSyBAn3E9qToh90dr5MxnQCd8dqm229q-FFg").build();
	}
	
	public LocationVO getAddress(LocationVO alvo) {
		LocationVO retVO = alDAO.getAddress(alvo);
		if(retVO==null) {
			retVO = requestAddress4Google(alvo);
			if(retVO==null)
				System.out.println("구글에도 값이 없대요");
			else
				alDAO.insertAddressLocation(retVO);
		}
		return retVO;
	}
	
	private LocationVO requestAddress4Google(LocationVO alvo) {
		System.out.println("requestAddress4Google");
		String loc = alvo.getLatitude() + ", " + alvo.getLongitude();
		try {
			GeocodingResult[] results = GeocodingApi.geocode(context, loc).language("ko").await();
			alvo.setAddress(results[0].formattedAddress);
			return alvo;
		} catch (ApiException | InterruptedException | IOException e) {
			return null;
		}
	}
	
	public LocationVO getLocation(LocationVO alvo) {
		LocationVO retVO = alDAO.getLocation(alvo);
		if(retVO==null) {
			retVO = requestLocation4Google(alvo);
			if(retVO==null)
				System.out.println("구글에도 값이 없대요");
			else
				alDAO.insertAddressLocation(retVO);
		}
		return retVO;
	}
	
	private LocationVO requestLocation4Google(LocationVO alvo) {
		System.out.println("requestLocation4Google");
		try {
			GeocodingResult[] results = GeocodingApi.geocode(context, alvo.getAddress()).language("ko").await();
			alvo.setLatitude((float)results[0].geometry.location.lat);
			alvo.setLongitude((float)results[0].geometry.location.lng);
			return alvo;
		} catch (ApiException | InterruptedException | IOException e) {
			return null;
		}
	}
}
