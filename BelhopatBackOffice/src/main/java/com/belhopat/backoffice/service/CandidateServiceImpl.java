package com.belhopat.backoffice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.User;
import com.belhopat.backoffice.repository.CandidateRepository;

@Component
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	CandidateRepository candidateRepository;
	
	@Override
	public DataTablesOutput<Candidate> getCandidates(DataTablesInput input) {
		DataTablesOutput<Candidate> dataTablesOutput = candidateRepository.findAll(input);
		return dataTablesOutput;
	}

	@Override
	public ResponseEntity<Candidate> getCandidate(Long candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId);
		if(candidate==null){
			return new ResponseEntity<Candidate>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Candidate>(candidate,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> saveOrUpdateCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteCandidates(List<Long> candidateIds) {
		List<Candidate> candidates = candidateRepository.findByIdIn(candidateIds);
		for (Candidate candidate : candidates) {
			candidate.setDeleteAttributes(new User(1L));
		}
		candidateRepository.save(candidates);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteCandidate(Long candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId);
		candidate.setDeleteAttributes(new User(1L));
		candidateRepository.save(candidate);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	}
