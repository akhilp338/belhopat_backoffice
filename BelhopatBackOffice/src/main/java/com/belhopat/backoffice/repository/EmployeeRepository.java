package com.belhopat.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, DataTablesRepository<Employee, Long> {

	Employee findById(Long candidateId);

	List<Employee> findByIdIn(List<Long> candidateIds);

}
