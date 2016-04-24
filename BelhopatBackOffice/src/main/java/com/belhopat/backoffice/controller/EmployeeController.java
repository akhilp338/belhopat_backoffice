package com.belhopat.backoffice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
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
	public ResponseEntity<String> saveOrUpdateEmployee(@RequestBody Employee employee) {
		return employeeService.saveOrUpdateEmployee(employee);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public DataTablesOutput<Employee> getEmployee(@Valid DataTablesInput input) {
		return employeeService.getEmployee(input);
	}
}
