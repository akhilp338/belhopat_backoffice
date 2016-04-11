package com.belhopat.backoffice.service;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.belhopat.backoffice.model.OfficialDetails;

@Service
public interface OfficialDetailsService {

	DataTablesOutput<OfficialDetails> getOfficialDetails(DataTablesInput input);

}
