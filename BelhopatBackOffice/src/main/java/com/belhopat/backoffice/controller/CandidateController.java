package com.belhopat.backoffice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.OfficialDetails;
import com.belhopat.backoffice.service.CandidateService;
import com.belhopat.backoffice.service.OfficialDetailsService;

@Controller
@RequestMapping("/api/candidate")
public class CandidateController {

	@Autowired
	CandidateService candidateService;
	
	@Autowired
	OfficialDetailsService officialDetailsService;
	
	@ResponseBody
	@RequestMapping(value = "/getCandidates", method = RequestMethod.POST)
	public DataTablesOutput<Candidate> getCandidates( @Valid DataTablesInput input ) {
		return candidateService.getCandidates(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCandidate", method = RequestMethod.POST)
	public ResponseEntity<Candidate> getCandidate(@RequestParam Long candidateId) {
		return candidateService.getCandidate(candidateId);
	}

	@ResponseBody
	@RequestMapping(value = "/saveOrUpdateCandidate", method = RequestMethod.POST)
	public ResponseEntity<Void> saveOrUpdateCandiadte(@RequestBody Candidate candidate) {
		return candidateService.saveOrUpdateCandidate(candidate);
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteCandidates", method = RequestMethod.POST)
	public ResponseEntity<Void> deleteCandiadtes(@RequestBody List<Long> candidateIds) {
		return candidateService.deleteCandidates(candidateIds);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getOfficialDetails", method = RequestMethod.GET)
	public DataTablesOutput<OfficialDetails> getOfficialDetails( @Valid DataTablesInput input ) {
		return officialDetailsService.getOfficialDetails(input);
	}

}