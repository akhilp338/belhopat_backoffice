package com.belhopat.backoffice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.belhopat.backoffice.model.Candidate;


@Service
public interface CandidateService {
	
	ResponseEntity<Candidate> getCandidate(Long candidateId);
	
	ResponseEntity<Void> saveOrUpdateCandidate(Candidate candidate);
	
	ResponseEntity<Void> deleteCandidates(List<Long> candidateIds);

}
