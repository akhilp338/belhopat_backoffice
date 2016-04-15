package com.belhopat.backoffice.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.User;
import com.belhopat.backoffice.repository.CandidateRepository;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.CandidateService;
import com.belhopat.backoffice.session.SessionManager;
import com.belhopat.backoffice.util.sequence.SequenceGenerator;

@Component
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	BaseService baseService;
	
	@Autowired
	CandidateRepository candidateRepository;
	
	@Override
	public DataTablesOutput < Candidate > getCandidates( DataTablesInput input ) {
		
		Specification< Candidate > specification = new Specification< Candidate >() {
            @Override
            public Predicate toPredicate( Root< Candidate > root,
                CriteriaQuery< ? > criteriaQuery, CriteriaBuilder criteriaBuilder ) {
                Predicate isNotDeleted =
                    criteriaBuilder.equal( root.get( "deleted" ), false );
                return criteriaBuilder.and(isNotDeleted );
            }
        };
		DataTablesOutput < Candidate > dataTablesOutput = candidateRepository.findAll ( input, specification );
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
		candidate.setBaseAttributes(new User(1L));
		if( candidate.getId() == null ){ candidate.setCandidateId ( SequenceGenerator.generateCandidateId(
				baseService.getSequenceIncrement( Candidate.class ) ) ); }
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
		if(candidateId!=null){
			Candidate candidate = candidateRepository.findById(candidateId);
			User loggedUser = SessionManager.getCurrentUserAsEntity();
			candidate.setDeleteAttributes(loggedUser);
			candidateRepository.save(candidate);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	}
