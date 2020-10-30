package com.investmenttracker.parent.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.investmenttracker.parent.beans.UserBean;
import com.investmenttracker.parent.entity.Users;
import com.investmenttracker.parent.service.impl.InvestmentTrackerServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class InvestmentTrackerController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private InvestmentTrackerServiceImpl service;
	
	
	@PostMapping("/registerUser")
	public Users registerUser(@Validated @RequestBody UserBean user) {
		LOGGER.info("Inside registerUser method of InvestmentTrackerController");
		return service.registerUser(user);
	}
	
	@PostMapping("/login")
	public Users loginAuthentication(@Validated @RequestBody UserBean user) {
		LOGGER.info("Inside loginAuthentication method of InvestmentTrackerController");
		return service.loginAuthentication(user);
	}


}
