package com.belhopat.backoffice.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.belhopat.backoffice.model.City;
import com.belhopat.backoffice.model.State;

@Service
public interface BaseService {

	ResponseEntity<Map<String, List<?>>> getCandidateDropDownData();

	ResponseEntity<List<State>> getStatesByCountry(Long countryId);

	ResponseEntity<List<City>> getCitiesByState(Long stateId);

}
