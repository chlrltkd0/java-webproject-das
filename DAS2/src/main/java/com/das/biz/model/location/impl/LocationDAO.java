package com.das.biz.model.location.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.location.LocationVO;

@Repository
public class LocationDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertAddressLocation(LocationVO alvo) {
		// 주소랑 좌표를 범위로 만들지 않아서 발생하는 에러
		try {
			mybatis.insert("LocationDAO.insertLocation", alvo);
		} catch(Exception e) {
			System.out.println("error");
		}
		
	}

	public LocationVO getAddress(LocationVO alvo) {
		return mybatis.selectOne("LocationDAO.getAddress", alvo);
	}
	
	public LocationVO getLocation(LocationVO alvo) {
		return mybatis.selectOne("LocationDAO.getLocation", alvo);
	}
}
