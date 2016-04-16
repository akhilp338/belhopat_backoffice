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
import com.belhopat.backoffice.model.State;
import com.belhopat.backoffice.repository.CandidateSequenceRepository;
import com.belhopat.backoffice.repository.CityRepository;
import com.belhopat.backoffice.repository.CountryRepository;
import com.belhopat.backoffice.repository.LookupDetailRepository;
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
	CandidateSequenceRepository candidateSequenceRepository;

	@Override
	public ResponseEntity<Map<String, List<?>>> getCandidateDropDownData() {
		List<LookupDetail> division = lookupDetailRepository.findByLookupKey(Constants.DIVISION);
		List<LookupDetail> designation = lookupDetailRepository.findByLookupKey(Constants.DESIGNATION);
		List<LookupDetail> purpose = lookupDetailRepository.findByLookupKey(Constants.PURPOSE);
		List<LookupDetail> bloodGroup = lookupDetailRepository.findByLookupKey(Constants.BLOOD_GROUP);
		List<LookupDetail> employmentStatus = lookupDetailRepository.findByLookupKey(Constants.EMPLOYMENT_STATUS);
		List<Country> country = countryRepository.findAll();
		Map<String, List<?>> dropDownMap = new HashMap<>();
		dropDownMap.put(Constants.DIVISION, division);
		dropDownMap.put(Constants.DESIGNATION, designation);
		dropDownMap.put(Constants.PURPOSE, purpose);
		dropDownMap.put(Constants.BLOOD_GROUP, bloodGroup);
		dropDownMap.put(Constants.EMPLOYMENT_STATUS, employmentStatus);
		dropDownMap.put(Constants.COUNTRY, country);
		return new ResponseEntity<Map<String, List<?>>>(dropDownMap, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<State>> getStatesByCountry(Long countryId) {
		List<State> states = stateRepository.findByCountry(countryId);
		return new ResponseEntity<List<State>>(states, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<City>> getCitiesByState(Long stateId) {
		List<City> states = cityRepository.findByState(stateId);
		return new ResponseEntity<List<City>>(states, HttpStatus.OK);
	}

	@Override
	public <T> Long getSequenceIncrement( Class<T> clazz ) {
        Long increment = null;
        if ( clazz.equals( Candidate.class ) ){
            CandidateSequence candidateSequence = candidateSequenceRepository
                .save( new CandidateSequence() );
            increment = candidateSequence.getId();
        }
        return increment;
	}
}
