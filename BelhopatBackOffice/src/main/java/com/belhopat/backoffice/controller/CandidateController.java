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

import com.belhopat.backoffice.dto.RequestObject;
import com.belhopat.backoffice.model.Candidate;
import com.belhopat.backoffice.model.LookupDetail;
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.CandidateService;

@Controller
@RequestMapping("/api/candidate")
public class CandidateController {

	@Autowired
	BaseService baseService;

	@Autowired
	CandidateService candidateService;

	@ResponseBody
	@RequestMapping(value = "/getCandidates", method = RequestMethod.GET)
	public DataTablesOutput<Candidate> getCandidates(@Valid DataTablesInput input) {
		return candidateService.getCandidates(input);
	}

	@ResponseBody
	@RequestMapping(value = "/getCandidate", method = RequestMethod.POST)
	public ResponseEntity<Candidate> getCandidate(@RequestBody RequestObject requestObject) {
		return candidateService.getCandidate(requestObject.getId());
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
	public ResponseEntity<Void> deleteCandiadte(@RequestBody RequestObject requestObject) {
		return candidateService.deleteCandidate(requestObject.getId());
	}

	@ResponseBody
	@RequestMapping(value = "/getDropDownData", method = RequestMethod.POST)
	public ResponseEntity<Map<String, List<?>>> getDropDownData() {
		return baseService.getCandidateDropDownData();
	}

}