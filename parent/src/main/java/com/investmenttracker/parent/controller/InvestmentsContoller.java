package com.investmenttracker.parent.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.investmenttracker.parent.entity.InvestmentDetails;
import com.investmenttracker.parent.service.impl.InvestmentsServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@EnableCircuitBreaker
@RestController
public class InvestmentsContoller {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private InvestmentsServiceImpl service;
	
	@GetMapping("/getInvDetails/{userId}")
	public List<InvestmentDetails> getUserInvDetails(@PathVariable long userId) {

		LOGGER.info("Controller");
		return service.getUserInvDetails(userId);
	}

	@PostMapping("/addInvDetails")
	public InvestmentDetails addUserInvDetails(@RequestBody InvestmentDetails details) {

		LOGGER.info("Controller");
		return service.addUserInvDetails(details);
	}
	
	@PostMapping("/updateInvDetails")
	public InvestmentDetails updateUserInvDetails(@RequestBody InvestmentDetails details) {

		LOGGER.info("Controller");
		return service.updateUserInvDetails(details);
	}
	
	@DeleteMapping("/delInvDetails/{invId}")
	public String delInvDetails(@PathVariable long invId) {

		LOGGER.info("Controller");
		return service.delInvDetails(invId);
	}
	
	@GetMapping("/getInvDetailsByInvId/{invId}")
	public InvestmentDetails getInvDetailsByInvId(@PathVariable long invId) {

		LOGGER.info("Controller getInvDetailsByInvId");
		return service.getInvDetailsByInvId(invId);
	}


}
