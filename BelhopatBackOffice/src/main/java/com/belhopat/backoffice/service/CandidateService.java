package com.belhopat.backoffice.service;

import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.belhopat.backoffice.model.Candidate;


@Service
public interface CandidateService {
	
	DataTablesOutput<Candidate> getCandidates(DataTablesInput input);
	
	ResponseEntity<Candidate> getCandidate(Long candidateId);
	
	ResponseEntity<Void> saveOrUpdateCandidate(Candidate candidate);
	
	ResponseEntity<Void> deleteCandidates(List<Long> candidateIds);

	ResponseEntity<Void> deleteCandidate(Long candidateId);

}
