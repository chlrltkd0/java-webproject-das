package com.das.biz.model.party.contactpoint.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.biz.model.party.contactpoint.ContactService;
import com.das.biz.model.party.contactpoint.ContactTypeVO;
import com.das.biz.model.party.contactpoint.impl.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO contactDAO;

	@Override
	public List<ContactTypeVO> getContextType() {
		return contactDAO.getContactType();
	}

}
