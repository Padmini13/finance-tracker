package com.investmenttracker.parent.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.investmenttracker.parent.beans.UserBean;
import com.investmenttracker.parent.entity.UserSequenceGenerator;
import com.investmenttracker.parent.entity.Users;
import com.investmenttracker.parent.repository.UserRepository;
import com.mongodb.client.MongoClient;

@Service
public class InvestmentTrackerServiceImpl{
	
	@Autowired
	private UserRepository rep;
	@Autowired
	private UserSequenceGenerator seq;
	
	@Autowired
	private MongoTemplate temp;
	
	 private static final Logger LOGGER=LoggerFactory.getLogger(InvestmentTrackerServiceImpl.class);


	public Users registerUser(UserBean userDetails) {
		LOGGER.info("Inside registerUser method of InvestmentTrackerServiceImpl");
		LOGGER.info("Inside registerUser method of RegisterService");
		Users chkForExistingUSer = rep.findByEmailId(userDetails.getEmailId());
		if (null != chkForExistingUSer) {
			return new Users();
		} else {
			Users user = new Users();
			user.setUserId(seq.generateSequence(Users.SEQUENCE_NAME));
			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setPassword(userDetails.getPassword());
			user.setEmailId(userDetails.getEmailId());
			user.setPAN(userDetails.getPanNumber());
			user.setPhoneNumber(userDetails.getPhoneNumber());
			
			return rep.save(user);
		}
	}


	public Users loginAuthentication(UserBean user) {
		LOGGER.info("Inside loginAuthentication method of InvestmentTrackerServiceImpl");
		Users userDet = new Users();
		userDet = rep.findByEmailIdAndPassword(user.getEmailId(),user.getPassword());
		userDet.setToken("fake-jwt-token");
		return userDet;
		
	}

	}

