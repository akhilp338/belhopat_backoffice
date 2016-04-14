package com.belhopat.backoffice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.belhopat.backoffice.model.LookupDetail;
import com.belhopat.backoffice.repository.LookupDetailRepository;
import com.belhopat.backoffice.util.Constants;

@Component
public class BaseServiceImpl implements BaseService {

	@Autowired
	LookupDetailRepository lookupDetailRepository;

	@Override
	public ResponseEntity<Map<String, List<LookupDetail>>> getCandidateDropDownData() {
		List<LookupDetail> division = lookupDetailRepository.findByLookupKey(Constants.DIVISION);
		List<LookupDetail> designation = lookupDetailRepository.findByLookupKey(Constants.DESIGNATION);
		List<LookupDetail> purpose = lookupDetailRepository.findByLookupKey(Constants.PURPOSE);
		List<LookupDetail> bloodGroup = lookupDetailRepository.findByLookupKey(Constants.BLOOD_GROUP);
		List<LookupDetail> employmentStatus = lookupDetailRepository.findByLookupKey(Constants.EMPLOYMENT_STATUS);
		Map<String, List<LookupDetail>> dropDownMap = new HashMap<>();
		dropDownMap.put(Constants.DIVISION, division);
		dropDownMap.put(Constants.DESIGNATION, designation);
		dropDownMap.put(Constants.PURPOSE, purpose);
		dropDownMap.put(Constants.BLOOD_GROUP, bloodGroup);
		dropDownMap.put(Constants.EMPLOYMENT_STATUS, employmentStatus);
		return new ResponseEntity<Map<String, List<LookupDetail>>>(dropDownMap, HttpStatus.OK);
	}
}
