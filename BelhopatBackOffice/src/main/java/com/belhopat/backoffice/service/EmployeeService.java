package com.belhopat.backoffice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.Employee;

@Service
public interface EmployeeService {

	public ResponseEntity<String> saveOrUpdateEmployee(Employee employee);

}
