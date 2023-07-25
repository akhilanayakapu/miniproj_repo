package com.akhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhi.binding.CitizenPlan;
import com.akhi.binding.SearchRequest;
import com.akhi.service.CitizenService;

@RestController
public class CitizenRestController {
	@Autowired
	private CitizenService ctservice;
	//for getting the data in dropdown getting unique plannames we use query in repo
	
	@GetMapping("/plannames")
	public ResponseEntity<List<String>> getPlanNames(){
		List<String> planNames = ctservice.getPlanNames();
		return new ResponseEntity<>(planNames,HttpStatus.OK);
	}
	@GetMapping("/planstatus")
	public ResponseEntity<List<String>> getPlanStatus(){
		List<String> planstatus = ctservice.getPlanStatus();
		return new ResponseEntity<>(planstatus,HttpStatus.OK);
}

/*  for searching the data based on given input.input might be
 planname,planstatus,gender or null */ 
 	@PostMapping("/search")
	public ResponseEntity<List<CitizenPlan>> search(@RequestBody SearchRequest request){
		List<CitizenPlan> citizenPlans = ctservice.getCitizenPlans(request);
		return new ResponseEntity<>(citizenPlans,HttpStatus.OK);
	}
	
	
	
	
	
}
