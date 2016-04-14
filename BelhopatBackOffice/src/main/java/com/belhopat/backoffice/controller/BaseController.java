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
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.OfficialDetailsService;

@Controller
@RequestMapping("/api")
public class BaseController {

	@Autowired
	BaseService baseService;

	@Autowired
	OfficialDetailsService officialDetailsService;

	@ResponseBody
	@RequestMapping(value = "/getDropDownData", method = RequestMethod.GET)
	public DataTablesOutput<Candidate> getDropDownData(@Valid DataTablesInput input) {
		return null;
	}

}
