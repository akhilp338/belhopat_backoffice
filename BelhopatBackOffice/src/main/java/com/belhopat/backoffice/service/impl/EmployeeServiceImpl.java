package com.belhopat.backoffice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.Employee;
import com.belhopat.backoffice.model.User;
import com.belhopat.backoffice.repository.EmployeeRepository;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.EmployeeService;
import com.belhopat.backoffice.session.SessionManager;
import com.belhopat.backoffice.util.sequence.SequenceGenerator;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	BaseService baseService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<String> saveOrUpdateEmployee(Employee employee) {
		User loggedInUser = SessionManager.getCurrentUserAsEntity();
		if (employee.getId() == null) {
			employee.setBaseAttributes(loggedInUser);
			Long increment = baseService.getSequenceIncrement(Candidate.class);
			String candidateId = SequenceGenerator.generateEmployeeId(increment);
			employee.setEmployeeId(candidateId);
		} else {
			employee.setUpdateAttributes(loggedInUser);
		}
		employee = employeeRepository.save(employee);
		if (employee != null) {
			String employeeName = employee.getEmployeeMaster().getFirstName() + " " + employee.getEmployeeMaster().getLastName();
			return new ResponseEntity<String>(employeeName, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

}
