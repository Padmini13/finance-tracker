package com.investmenttracker.parent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmenttracker.parent.entity.InvestmentDetails;
import com.investmenttracker.parent.entity.UserSequenceGenerator;
import com.investmenttracker.parent.entity.Users;
import com.investmenttracker.parent.repository.UserInvestmentDetailsRepo;

@Service
public class InvestmentsServiceImpl  {

	@Autowired
	private UserSequenceGenerator seq;

	@Autowired
	private UserInvestmentDetailsRepo invDetailsRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(InvestmentsServiceImpl.class);

	
	public List<InvestmentDetails> getUserInvDetails(long userId) {
		LOGGER.info("Service Inside");
		List<InvestmentDetails> invDetails = invDetailsRepo.findByUserId(userId);
		for (InvestmentDetails details : invDetails) {
			details.setPercentage(CalcProfitOrLossPercentage(details));
		}
		return invDetails;
	}

	
	public List<InvestmentDetails> getAllDetails() {
		LOGGER.info("Service getAllDetails");
		return invDetailsRepo.findAll();
	}


	public InvestmentDetails addUserInvDetails(InvestmentDetails details) {
		details.setInvId(seq.generateSequence(Users.SEQUENCE_NAME));
		LOGGER.info("addUserInvDetails ---- " + details.getInvId());
		InvestmentDetails resDetails=invDetailsRepo.save(details);
		resDetails.setPercentage(CalcProfitOrLossPercentage(resDetails));
		return resDetails;

	}

	
	public InvestmentDetails updateUserInvDetails(InvestmentDetails newDetails) {
		LOGGER.info("upadte service");
		InvestmentDetails oldDetails = invDetailsRepo.findByInvId(newDetails.getInvId());
		newDetails.setInvId(oldDetails.getInvId());
		invDetailsRepo.save(newDetails);
		newDetails.setPercentage(CalcProfitOrLossPercentage(newDetails));
		return newDetails;

	}

	private long CalcProfitOrLossPercentage(InvestmentDetails invDetails) {
		long percentage = (invDetails.getCurrentPrice() - invDetails.getCostPrice()) * 100
				/ invDetails.getCostPrice();
		System.out.println(percentage+ "!!!!!!!!!!!!!!!!!!!!");
		return percentage;

	}

	
	public String delInvDetails(long invId) {
		invDetailsRepo.deleteById(invId);
		return "Record Deleted";
	}


	public InvestmentDetails getInvDetailsByInvId(long invId) {
		LOGGER.info("Service Inside getInvDetailsByInvId");
		InvestmentDetails invDetails = invDetailsRepo.findByInvestmentId(invId);
		return invDetails;
	}
}
