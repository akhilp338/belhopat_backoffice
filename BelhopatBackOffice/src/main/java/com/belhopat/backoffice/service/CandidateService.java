package com.belhopat.backoffice.service;

import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.util.ResponseObject;

@Service
public interface CandidateService {

	public DataTablesOutput<Candidate> getCandidates(DataTablesInput input);

	public ResponseEntity<Candidate> getCandidate(Long candidateId);

	public ResponseEntity<String> saveOrUpdateCandidate(Candidate candidate);

	public ResponseEntity<Void> deleteCandidates(List<Long> candidateIds);

	public ResponseEntity<ResponseObject> deleteCandidate(Long candidateId);

}
