package com.belhopat.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.Employee;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.CandidateService;
import com.belhopat.backoffice.service.EmployeeService;
@Controller
@RequestMapping("/api/employee")
public class EmployeeController {


	@Autowired
	BaseService baseService;

	@Autowired
	EmployeeService employeeService;
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdateEmployee", method = RequestMethod.POST)
	public ResponseEntity<String> saveOrUpdateCandidate(@RequestBody Employee employee) {
		return employeeService.saveOrUpdateEmployee(employee);
	}
}
