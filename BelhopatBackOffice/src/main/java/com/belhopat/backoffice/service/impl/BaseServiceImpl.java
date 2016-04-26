package com.belhopat.backoffice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.CandidateSequence;
import com.belhopat.backoffice.model.City;
import com.belhopat.backoffice.model.Country;
import com.belhopat.backoffice.model.LookupDetail;
import com.belhopat.backoffice.model.Skill;
import com.belhopat.backoffice.model.State;
import com.belhopat.backoffice.repository.CandidateSequenceRepository;
import com.belhopat.backoffice.repository.CityRepository;
import com.belhopat.backoffice.repository.CountryRepository;
import com.belhopat.backoffice.repository.LookupDetailRepository;
import com.belhopat.backoffice.repository.SkillRepository;
import com.belhopat.backoffice.repository.StateRepository;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.util.Constants;

@Component
public class BaseServiceImpl implements BaseService {

	@Autowired
	LookupDetailRepository lookupDetailRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;
	

	@Autowired
	SkillRepository skillRepository;

	@Autowired
	CandidateSequenceRepository candidateSequenceRepository;

	@Override
	public ResponseEntity<Map<String, List<?>>> getCandidateDropDownData() {
		List<LookupDetail> divisions = lookupDetailRepository.findByLookupKey(Constants.DIVISION);
		List<LookupDetail> designations = lookupDetailRepository.findByLookupKey(Constants.DESIGNATION);
		List<LookupDetail> purposes = lookupDetailRepository.findByLookupKey(Constants.PURPOSE);
		List<LookupDetail> bloodGroups = lookupDetailRepository.findByLookupKey(Constants.BLOOD_GROUP);
		List<LookupDetail> employmentStatuses = lookupDetailRepository.findByLookupKey(Constants.EMPLOYMENT_STATUS);
		List<LookupDetail> familyMembers = lookupDetailRepository.findByLookupKey(Constants.FAMILY_MEMBER);
		List<Skill> skills = skillRepository.findAll();
		List<Country> countries = countryRepository.findAll();
		Map<String, List<?>> dropDownMap = new HashMap<>();
		dropDownMap.put(Constants.DIVISION, divisions);
		dropDownMap.put(Constants.DESIGNATION, designations);
		dropDownMap.put(Constants.PURPOSE, purposes);
		dropDownMap.put(Constants.BLOOD_GROUP, bloodGroups);
		dropDownMap.put(Constants.EMPLOYMENT_STATUS, employmentStatuses);
		dropDownMap.put(Constants.FAMILY_MEMBER, familyMembers);
		dropDownMap.put(Constants.SKILL, skills);
		dropDownMap.put(Constants.COUNTRY, countries);
		return new ResponseEntity<Map<String, List<?>>>(dropDownMap, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, List<?>>> getEmployeeDropDownData() {
		List<LookupDetail> divisions = lookupDetailRepository.findByLookupKey(Constants.DIVISION);
		List<LookupDetail> designations = lookupDetailRepository.findByLookupKey(Constants.DESIGNATION);
		List<LookupDetail> purposes = lookupDetailRepository.findByLookupKey(Constants.PURPOSE);
		List<LookupDetail> bloodGroups = lookupDetailRepository.findByLookupKey(Constants.BLOOD_GROUP);
		List<LookupDetail> employmentStatuses = lookupDetailRepository.findByLookupKey(Constants.EMPLOYMENT_STATUS);
		List<LookupDetail> familyMembers = lookupDetailRepository.findByLookupKey(Constants.FAMILY_MEMBER);
		List<Skill> skills = skillRepository.findAll();
		List<Country> countries = countryRepository.findAll();
		Map<String, List<?>> dropDownMap = new HashMap<>();
		dropDownMap.put(Constants.DIVISION, divisions);
		dropDownMap.put(Constants.DESIGNATION, designations);
		dropDownMap.put(Constants.PURPOSE, purposes);
		dropDownMap.put(Constants.BLOOD_GROUP, bloodGroups);
		dropDownMap.put(Constants.EMPLOYMENT_STATUS, employmentStatuses);
		dropDownMap.put(Constants.FAMILY_MEMBER, familyMembers);
		dropDownMap.put(Constants.SKILL, skills);
		dropDownMap.put(Constants.COUNTRY, countries);
		return new ResponseEntity<Map<String, List<?>>>(dropDownMap, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<State>> getStatesByCountry(Long countryId) {
		List<State> states = stateRepository.findByCountry(countryId);
		return new ResponseEntity<List<State>>(states, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<City>> getCitiesByState(Long stateId) {
		List<City> states = cityRepository.findByStateId(stateId);
		return new ResponseEntity<List<City>>(states, HttpStatus.OK);
	}
	
	@Override
	public List<Skill> getUnselectedSkillSet(List<Skill> selectedSkillSet){
		List<Skill> skillSet = skillRepository.findAll();
		if(!selectedSkillSet.isEmpty()){
			for (Skill skill : selectedSkillSet) {
				if(skillSet.contains(skill))
					skillSet.remove(skill);
			}
		}
		return skillSet;
	}


	@Override
	public <T> Long getSequenceIncrement(Class<T> clazz) {
		Long increment = null;
		if (clazz.equals(Candidate.class)) {
			CandidateSequence candidateSequence = candidateSequenceRepository.save(new CandidateSequence());
			increment = candidateSequence.getId();
		}
		return increment;
	}
}
