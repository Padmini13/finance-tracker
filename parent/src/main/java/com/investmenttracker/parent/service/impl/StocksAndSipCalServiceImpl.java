package com.investmenttracker.parent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmenttracker.parent.entity.InvestmentDetails;
import com.investmenttracker.parent.entity.SIPDetails;
import com.investmenttracker.parent.entity.Stocks;
import com.investmenttracker.parent.entity.StocksSequence;
import com.investmenttracker.parent.entity.StocksSequenceGenerator;
import com.investmenttracker.parent.repository.StocksRepository;
import com.investmenttracker.parent.repository.UserInvestmentDetailsRepo;

@Service
public class StocksAndSipCalServiceImpl {
	
	@Autowired
	UserInvestmentDetailsRepo Invrepo;
	
	@Autowired
	StocksRepository stockRepo;
	
	
	@Autowired
	private StocksSequenceGenerator seq;
	

	public List<Stocks> getStockDetails() {
		return stockRepo.findAll();
	}


	public String addStocktoUser(Stocks data) {
		InvestmentDetails resDetails = new InvestmentDetails();
		resDetails.setInvId(seq.generateSequence(Stocks.SEQUENCE_NAME));
		resDetails.setInvsName(data.getInvsName());
		resDetails.setInvsType(data.getInvsType());
		resDetails.setQuantity(data.getQuantity());
		resDetails.setCurrentPrice(data.getCurrentPrice());
		resDetails.setCostPrice(data.getCurrentPrice());
		resDetails.setUserId(data.getUserId());
		resDetails.setPercentage(CalcProfitOrLossPercentage(resDetails));
		Invrepo.save(resDetails);
		return "Success";
		
	}
	
	private long CalcProfitOrLossPercentage(InvestmentDetails invDetails) {
		long percentage = (invDetails.getCurrentPrice() - invDetails.getCostPrice()) * 100
				/ invDetails.getCostPrice();
		System.out.println(percentage+ "!!!!!!!!!!!!!!!!!!!!");
		return percentage;

	}


	public double calculateSIP(SIPDetails data) {
		 double InvDuration = data.getInvDuration() *12;
		    double i = data.getRateOfReturn()/(100*InvDuration);
		    double FV = data.getAmount()*(Math.pow((1+i), InvDuration) - 1)/i *(1+i);
		    System.out.println("Estimated Value");
		    System.out.println(FV);
		    return Math.round(FV);
		       
	}


	public String getStockDetails(String name) {
		  Stocks result=stockRepo.findByInvsName(name);
	        return result.getDetails();
	}
}
