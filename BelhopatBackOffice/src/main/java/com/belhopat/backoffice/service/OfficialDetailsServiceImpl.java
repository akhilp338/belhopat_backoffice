package com.belhopat.backoffice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Component;

import com.belhopat.backoffice.model.OfficialDetails;
import com.belhopat.backoffice.repository.OfficialDetailsRepository;

@Component
public class OfficialDetailsServiceImpl implements OfficialDetailsService{
	
	@Autowired
	OfficialDetailsRepository officialDetailsRepository;
	
	@Override
	public DataTablesOutput<OfficialDetails>  getOfficialDetails(DataTablesInput input) {
		DataTablesOutput<OfficialDetails> dataTablesOutput = officialDetailsRepository.findAll(input);
		return dataTablesOutput;
	}

	}
