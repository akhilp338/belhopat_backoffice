package com.belhopat.backoffice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.belhopat.backoffice.model.BankAccount;
import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.Skill;
import com.belhopat.backoffice.model.User;
import com.belhopat.backoffice.repository.CandidateRepository;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.CandidateService;
import com.belhopat.backoffice.session.SessionManager;
import com.belhopat.backoffice.util.ResponseObject;
import com.belhopat.backoffice.util.sequence.SequenceGenerator;

/**
 * @author BHP_DEV Service layer to implement candidates business
 */
@Component
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	BaseService baseService;

	@Autowired
	CandidateRepository candidateRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.belhopat.backoffice.service.CandidateService#getCandidates(org.
	 * springframework.data.jpa.datatables.mapping.DataTablesInput)
	 * gets the candidates with appropriate specifications
	 * 
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.belhopat.backoffice.service.CandidateService#getCandidate(java.lang.
	 * Long)
	 * gets a single candidate with its id
	 */
	@Override
	public ResponseEntity<Candidate> getCandidate(Long candidateId) {
		Candidate candidate = candidateRepository.findById(candidateId);
		if (candidate != null) {
			List<Skill> unselectedSkillSet = baseService.getUnselectedSkillSet(candidate.getSkillSet());
			candidate.setUnselectedSkillSet(unselectedSkillSet);
			return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
		}
		return new ResponseEntity<Candidate>(HttpStatus.NO_CONTENT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.belhopat.backoffice.service.CandidateService#saveOrUpdateCandidate(
	 * com.belhopat.backoffice.model.Candidate)
	 * saves or updates the candidate to the database
	 */
	@Override
	public ResponseEntity<Map<String,String>> saveOrUpdateCandidate(Candidate candidateObj) {
		Map<String,String> responseMap = new HashMap<>();
		Candidate newCandidate = null;
		User loggedInUser = SessionManager.getCurrentUserAsEntity();
		if (candidateObj.getId() == null) {
			newCandidate = registerNewCandidate(loggedInUser, candidateObj);
		} else {
			newCandidate = updateCandidate(loggedInUser, candidateObj);
		}
		if (newCandidate != null) {
			responseMap.put("Message", newCandidate.getFirstName() + " " + newCandidate.getLastName());
			return new ResponseEntity<Map<String,String>>(responseMap, HttpStatus.OK);
		}
		return new ResponseEntity<Map<String,String>>( responseMap,HttpStatus.NO_CONTENT);
	}

	
	/**
	 * @param loggedInUser
	 * @param candidateObj
	 * @return Candidate
	 * sets the dto to entity
	 */
	private Candidate updateCandidate(User loggedInUser, Candidate candidateObj) {
		Candidate newCandidate = candidateRepository.findById(candidateObj.getId());
		newCandidate = getUpdatedWithBaseAttributes(candidateObj, newCandidate);
		if (candidateObj.getBankAccount() != null) {
			newCandidate = setBankAccountInDetail(candidateObj.getBankAccount(), newCandidate);
		}
		if (candidateObj.getBloodGroup() != null) {
			newCandidate.setBloodGroup(candidateObj.getBloodGroup());
		}
		if (candidateObj.getCountryOfOrigin() != null) {
			newCandidate.setCountryOfOrigin(candidateObj.getCountryOfOrigin());
		}
		if (candidateObj.getCountryToVisit() != null) {
			newCandidate.setCountryToVisit(candidateObj.getCountryToVisit());
		}
		if (candidateObj.getCurrentAddress() != null) {
			newCandidate.setCurrentAddress(candidateObj.getCurrentAddress());
		}
		if (candidateObj.getDesignation() != null) {
			newCandidate.setDesignation(candidateObj.getDesignation());
		}
		if (candidateObj.getDivision() != null) {
			newCandidate.setDivision(candidateObj.getDivision());
		}
		if (candidateObj.getEmploymentStatus() != null) {
			newCandidate.setEmploymentStatus(candidateObj.getEmploymentStatus());
		}
		if (candidateObj.getFamilyMembers() != null && !candidateObj.getFamilyMembers().isEmpty()) {
			newCandidate.setFamilyMembers(candidateObj.getFamilyMembers());
		}
		if (candidateObj.getOfficialDetails() != null) {
			newCandidate.setOfficialDetails(candidateObj.getOfficialDetails());
		}
		if (candidateObj.getOnsiteAddress() != null) {
			newCandidate.setOnsiteAddress(candidateObj.getOnsiteAddress());
		}
		if (candidateObj.getPassport() != null) {
			newCandidate.setPassport(candidateObj.getPassport());
		}
		if (candidateObj.getPermanentAddress() != null) {
			newCandidate.setPermanentAddress(candidateObj.getPermanentAddress());
		}
		if (candidateObj.getPurpose() != null) {
			newCandidate.setPurpose(candidateObj.getPurpose());
		}
		if (candidateObj.getRegistrationStatus() != null) {
			newCandidate.setRegistrationStatus(candidateObj.getRegistrationStatus());
		}
		if (candidateObj.getSkillSet() != null && !candidateObj.getSkillSet().isEmpty()) {
			newCandidate.setSkillSet(candidateObj.getSkillSet());
		}
		newCandidate.setUpdateAttributes(loggedInUser);
		Candidate persisted = candidateRepository.save(newCandidate);
		return persisted;
	}

	/**
	 * @param candidateObj
	 * @param newCandidate
	 * @return Candidate
	 * sets the base attributes
	 */
	private Candidate getUpdatedWithBaseAttributes(Candidate candidateObj, Candidate newCandidate) {
		newCandidate.setFirstName(candidateObj.getFirstName());
		newCandidate.setLastName(candidateObj.getLastName());
		newCandidate.setMiddleName(candidateObj.getMiddleName());
		newCandidate.setGender(candidateObj.getGender());
		newCandidate.setPersonalEmail(candidateObj.getPersonalEmail());
		newCandidate.setPersonalContactNo(candidateObj.getPersonalContactNo());
		newCandidate.setOfficialEmail(candidateObj.getOfficialEmail());
		newCandidate.setOfficialContactNo(candidateObj.getOfficialContactNo());
		newCandidate.setFamilyContact1(candidateObj.getFamilyContact1());
		newCandidate.setFamilyContact2(candidateObj.getFamilyContact2());
		newCandidate.setFamilyEmail(candidateObj.getFamilyEmail());
		newCandidate.setOnsiteContactNo(candidateObj.getOnsiteContactNo());
		newCandidate.setFathersName(candidateObj.getFathersName());
		newCandidate.setMothersName(candidateObj.getMothersName());
		newCandidate.setPriorExperienceMonth(candidateObj.getPriorExperienceMonth());
		newCandidate.setPriorExperienceYear(candidateObj.getPriorExperienceYear());
		newCandidate.setClient(candidateObj.getClient());
		newCandidate.setPartner(candidateObj.getPartner());
		newCandidate.setSourcedBy(candidateObj.getSourcedBy());
		newCandidate.setDob(candidateObj.getDob());
		newCandidate.setDoj(candidateObj.getDoj());
		return newCandidate;
	}

	/**
	 * @param bankAccount
	 * @param newCandidate
	 * @return Candidate
	 * sets the account details
	 */
	private Candidate setBankAccountInDetail(BankAccount bankAccount, Candidate newCandidate) {
		if (newCandidate.getBankAccount() != null) {
			newCandidate.getBankAccount().setAccountHolderName(bankAccount.getAccountHolderName());
			newCandidate.getBankAccount().setAccountNo(bankAccount.getAccountNo());
			newCandidate.getBankAccount().setBankAddress(bankAccount.getBankAddress());
			newCandidate.getBankAccount().setBankName(bankAccount.getBankName());
			newCandidate.getBankAccount().setBranch(bankAccount.getBranch());
			newCandidate.getBankAccount().setIFSCCode(bankAccount.getIFSCCode());
		} else {

		}
		return newCandidate;
	}

	/**
	 * @param loggedInUser
	 * @param candidate
	 * @return Candidate
	 * saves a new candidate to database
	 */
	private Candidate registerNewCandidate(User loggedInUser, Candidate candidate) {
		candidate.setBaseAttributes(loggedInUser);
		Long increment = baseService.getSequenceIncrement(Candidate.class);
		String candidateId = SequenceGenerator.generateCandidateId(increment);
		candidate.setCandidateId(candidateId);
		Candidate persisted = candidateRepository.save(candidate);
		return persisted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.belhopat.backoffice.service.CandidateService#deleteCandidates(java.
	 * util.List)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.belhopat.backoffice.service.CandidateService#deleteCandidate(java.
	 * lang.Long)
	 */
	@Override
	public ResponseEntity<ResponseObject> deleteCandidate(Long candidateId) {
		if (candidateId != null) {
			Candidate candidate = candidateRepository.findById(candidateId);
			User loggedInUser = SessionManager.getCurrentUserAsEntity();
			candidate.setUpdateAttributes(loggedInUser);
			candidate.setDeleteAttributes(loggedInUser);
			candidate = candidateRepository.save(candidate);
			if (candidate != null) {
				String candidateName = candidate.getFirstName() + " " + candidate.getLastName();
				return new ResponseEntity<ResponseObject>(
						new ResponseObject(true, candidateName + " successfully deleted"), HttpStatus.OK);
			}
		}
		return new ResponseEntity<ResponseObject>(new ResponseObject(true, "Oops..error while deleting!"),
				HttpStatus.OK);
	}

}
