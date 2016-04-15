package com.belhopat.backoffice.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.LookupDetail;
import com.belhopat.backoffice.model.OfficialCards;
import com.belhopat.backoffice.model.User;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.CandidateService;
import com.belhopat.backoffice.service.OfficialDetailsService;

@Controller
@RequestMapping("/api/candidate")
public class CandidateController {

	@Autowired
	CandidateService candidateService;
	
	@Autowired
	BaseService baseService;
	
	@Autowired
	OfficialDetailsService officialDetailsService;
	
	@ResponseBody
	@RequestMapping(value = "/getCandidates", method = RequestMethod.GET)
	public DataTablesOutput<Candidate> getCandidates( @Valid DataTablesInput input ) {
		return candidateService.getCandidates(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCandidate", method = RequestMethod.POST)
	public ResponseEntity<Candidate> getCandidate(@RequestBody User user) {
		return candidateService.getCandidate(user.getId());
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
	@RequestMapping(value = "/deleteCandidate", method = RequestMethod.POST)
	public ResponseEntity<Void> deleteCandiadte(@RequestBody User user) {
		return candidateService.deleteCandidate(user.getId());
	}
	
	@ResponseBody
	@RequestMapping(value = "/getDropDownData", method = RequestMethod.POST)
	public ResponseEntity<Map<String, List<LookupDetail>>> getDropDownData() {
		return baseService.getCandidateDropDownData();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getOfficialDetails", method = RequestMethod.GET)
	public DataTablesOutput<OfficialCards> getOfficialDetails( @Valid DataTablesInput input ) {
		return officialDetailsService.getOfficialDetails(input);
	}

}