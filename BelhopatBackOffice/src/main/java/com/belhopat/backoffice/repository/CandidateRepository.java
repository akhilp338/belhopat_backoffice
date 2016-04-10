package com.belhopat.backoffice.repository;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.belhopat.backoffice.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>, DataTablesRepository<Candidate, Long> {

	Candidate findById(Long candidateId);

	void deleteById(List<Long> candidateIds);

}
