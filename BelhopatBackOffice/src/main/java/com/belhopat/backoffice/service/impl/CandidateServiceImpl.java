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
import com.belhopat.backoffice.util.Constants;
import com.belhopat.backoffice.util.ResponseObject;
import com.belhopat.backoffice.util.sequence.SequenceGenerator;

@Component
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	BaseService baseService;

	@Autowired
	CandidateRepository candidateRepository;

	@Override
	public DataTablesOutput<Candidate> getCandidates(DataTablesInput input) {

		Specification<Candidate> specification = new Specification<Candidate>() {
			@Override
			public Predicate toPredicate(Root<Candidate> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {
				Predicate isNotDeleted = criteriaBuilder.equal(root.get("deleted"), false);
				return criteriaBuilder.and(isNotDeleted);
			}
		};
		DataTablesOutput<Candidate> dataTablesOutput = candidateRepository.findAll(input, specification);
		return dataTablesOutput;
	}

	@Override
	public ResponseEntity<Candidate> getCandidate(Long candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId);
		if (candidate == null) {
			return new ResponseEntity<Candidate>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> saveOrUpdateCandidate(Candidate candidate) {
		User loggedInUser = SessionManager.getCurrentUserAsEntity();
		if (candidate.getId() == null) {
			candidate.setBaseAttributes(loggedInUser);
			Long increment = baseService.getSequenceIncrement(Candidate.class);
			String candidateId = SequenceGenerator.generateCandidateId(increment);
			candidate.setCandidateId(candidateId);
		} else {
			candidate.setUpdateAttributes(loggedInUser);
		}
		candidate = candidateRepository.save(candidate);
		if(candidate!=null){
			String candidateName = candidate.getFirstName() + " " + candidate.getLastName();
			return new ResponseEntity<String>(candidateName,HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Void> deleteCandidates(List<Long> candidateIds) {
		User loggedInUser = SessionManager.getCurrentUserAsEntity();
		List<Candidate> candidates = candidateRepository.findByIdIn(candidateIds);
		for (Candidate candidate : candidates) {
			candidate.setDeleteAttributes(loggedInUser);
		}
		candidateRepository.save(candidates);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseObject> deleteCandidate(Long candidateId) {
		if (candidateId != null) {
			Candidate candidate = candidateRepository.findById(candidateId);
			User loggedInUser = SessionManager.getCurrentUserAsEntity();
			candidate.setUpdateAttributes(loggedInUser);
			candidate.setDeleteAttributes(loggedInUser);
			candidate = candidateRepository.save(candidate);
			if(candidate!=null){
				String candidateName = candidate.getFirstName() + " " + candidate.getLastName();
				return new ResponseEntity<ResponseObject>(new ResponseObject(true, candidateName+" successfully deleted"),
						HttpStatus.OK);
			}
		}
		return new ResponseEntity<ResponseObject>(new ResponseObject(true, "Oops..error while deleting!"),
				HttpStatus.OK);
	}

}
