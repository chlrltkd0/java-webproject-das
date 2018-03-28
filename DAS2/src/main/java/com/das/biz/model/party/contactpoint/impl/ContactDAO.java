package com.das.biz.model.party.contactpoint.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.das.biz.model.party.contactpoint.ContactTypeVO;
import com.das.biz.model.party.contactpoint.ContactVO;

@Repository
public class ContactDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertContact(ContactVO cvo) {
		mybatis.insert("ContactDAO.insertContact", cvo);
	}
	
	public void updateContact(ContactVO cvo) {
		mybatis.update("ContactDAO.updateContact", cvo);
	}
	
	public void deleteContact(ContactVO cvo) {
		mybatis.delete("ContactDAO.deleteContact", cvo);
	}
	
	public ContactVO getContact(ContactVO cvo) {
		return mybatis.selectOne("ContactDAO.getContact", cvo);
	}
	
	public List<ContactTypeVO> getContactType(){
		return mybatis.selectList("ContactDAO.getContactType");
	}
	

}
