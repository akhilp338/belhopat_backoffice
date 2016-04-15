package com.belhopat.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belhopat.backoffice.dto.RequestObject;
import com.belhopat.backoffice.model.City;
import com.belhopat.backoffice.model.State;
import com.belhopat.backoffice.service.BaseService;

@Controller
@RequestMapping("/api")
public class BaseController {

	@Autowired
	BaseService baseService;

	@ResponseBody
	@RequestMapping(value = "/getStatesByCountry", method = RequestMethod.GET)
	public ResponseEntity<List<State>> getStatesByCountry(@RequestBody RequestObject requestObject) {
		return baseService.getStatesByCountry(requestObject.getId());
	}

	@ResponseBody
	@RequestMapping(value = "/getCitiesByState", method = RequestMethod.GET)
	public ResponseEntity<List<City>> getCitiesByState(@RequestBody RequestObject requestObject) {
		return baseService.getCitiesByState(requestObject.getId());
	}

}
