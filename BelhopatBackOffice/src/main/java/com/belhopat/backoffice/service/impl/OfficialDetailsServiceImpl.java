package com.belhopat.backoffice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Component;

import com.belhopat.backoffice.model.OfficialCards;
import com.belhopat.backoffice.repository.OfficialDetailsRepository;
import com.belhopat.backoffice.service.OfficialDetailsService;

@Component
public class OfficialDetailsServiceImpl implements OfficialDetailsService{
	
	@Autowired
	OfficialDetailsRepository officialDetailsRepository;
	
	@Override
	public DataTablesOutput<OfficialCards>  getOfficialDetails(DataTablesInput input) {
		DataTablesOutput<OfficialCards> dataTablesOutput = officialDetailsRepository.findAll(input);
		return dataTablesOutput;
	}

	}
