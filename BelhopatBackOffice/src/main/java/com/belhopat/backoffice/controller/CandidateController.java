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
import com.belhopat.backoffice.service.BaseService;
import com.belhopat.backoffice.service.CandidateService;
import com.belhopat.backoffice.util.ResponseObject;

/**
 * @author Akhil Prakash
 *
 */
@Controller
@RequestMapping("/api/candidate")
public class CandidateController {

	@Autowired
	BaseService baseService;

	@Autowired
	CandidateService candidateService;

	/**
	 * @param input
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCandidates", method = RequestMethod.GET)

	public DataTablesOutput<Candidate> getCandidates(@Valid DataTablesInput input) {
		return candidateService.getCandidates(input);
	}

	/**
	 * @param requestObject
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCandidate", method = RequestMethod.POST)

	public ResponseEntity<Candidate> getCandidate(@RequestBody RequestObject requestObject) {
		return candidateService.getCandidate(requestObject.getId());
	}

	/**
	 * @param candidate
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdateCandidate", method = RequestMethod.POST)

	public ResponseEntity<String> saveOrUpdateCandidate(@RequestBody Candidate candidate) {
		return candidateService.saveOrUpdateCandidate(candidate);
	}

	/**
	 * @param candidateIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteCandidates", method = RequestMethod.POST)

	public ResponseEntity<Void> deleteCandidates(@RequestBody List<Long> candidateIds) {
		return candidateService.deleteCandidates(candidateIds);
	}

	/**
	 * @param requestObject
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteCandidate", method = RequestMethod.POST)

	public ResponseEntity<ResponseObject> deleteCandidate(@RequestBody RequestObject requestObject) {
		return candidateService.deleteCandidate(requestObject.getId());
	}

	/**
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getDropDownData", method = RequestMethod.POST)

	public ResponseEntity < Map < String, List < ? > > > getDropDownData() {
		return baseService.getCandidateDropDownData();
	}

}