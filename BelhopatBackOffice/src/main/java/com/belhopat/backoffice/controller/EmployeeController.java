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

import com.belhopat.backoffice.dto.RequestObject;
import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.Employee;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.CandidateService;
import com.belhopat.backoffice.service.EmployeeService;
/**
 * @author Akhil Prakash
 *
 */
@Controller
@RequestMapping("/api/employee")
public class EmployeeController {


	@Autowired
	BaseService baseService;

	@Autowired
	EmployeeService employeeService;
	
	/**
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdateEmployee", method = RequestMethod.POST)
	public ResponseEntity<String> saveOrUpdateEmployee(@RequestBody Employee employee) {
		return employeeService.saveOrUpdateEmployee(employee);
	}
	
	/**
	 * @param input
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public DataTablesOutput<Employee> getEmployee(@Valid DataTablesInput input) {
		return employeeService.getEmployee(input);
	}
	
	/**
	 * @param requestObject
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAnEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> getAnEmployee(@RequestBody RequestObject requestObject) {
		return employeeService.getAnEmployee(requestObject.getId());
	}

}
