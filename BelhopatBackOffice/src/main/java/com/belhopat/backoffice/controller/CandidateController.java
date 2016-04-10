package com.belhopat.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.service.CandidateService;

@Controller
@RequestMapping("/api/candidate")
public class CandidateController {

	@Autowired
	CandidateService candidateService;
	
	@RequestMapping(value = "/getCandiadte", method = RequestMethod.POST)
	public ResponseEntity<Candidate> getCandidate(@RequestParam Long candidateId) {
		return candidateService.getCandidate(candidateId);
	}

	@RequestMapping(value = "/saveOrUpdateCandiadte", method = RequestMethod.POST)
	public ResponseEntity<Void> saveOrUpdateCandiadte(@RequestBody Candidate candidate) {
		return candidateService.saveOrUpdateCandidate(candidate);
	}
	
	@RequestMapping(value = "/deleteCandiadtes", method = RequestMethod.POST)
	public ResponseEntity<Void> deleteCandiadtes(@RequestBody List<Long> candidateIds) {
		return candidateService.deleteCandidates(candidateIds);
	}

}