package com.belhopat.backoffice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.belhopat.backoffice.repository.ClientRepository;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.ClientService;
import com.belhopat.backoffice.service.PointOfContactService;

@Component
public class ClientServiceImpl implements ClientService{


	@Autowired
	BaseService baseService;

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	PointOfContactService pointOfContactService;
	
		
}
