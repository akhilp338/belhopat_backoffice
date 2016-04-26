package com.belhopat.backoffice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.Client;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.ClientService;

@Controller
@RequestMapping("/api/client")
public class ClientController {
	
	@Autowired
	BaseService baseService;

	@Autowired
	ClientService clientService;
	
	@ResponseBody
	@RequestMapping(value = "/getClients", method = RequestMethod.GET)
	public DataTablesOutput < Client > getClients(@Valid DataTablesInput input) {
//		return clientService.getClients(input);
		return null;
	}

}
