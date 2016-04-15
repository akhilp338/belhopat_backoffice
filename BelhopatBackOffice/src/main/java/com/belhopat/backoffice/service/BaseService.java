package com.belhopat.backoffice.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.belhopat.backoffice.model.LookupDetail;

@Service
public interface BaseService {

	ResponseEntity<Map<String, List<LookupDetail>>> getCandidateDropDownData();

}