package com.investmenttracker.parent.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.investmenttracker.parent.entity.InvestmentDetails;

public interface UserInvestmentDetailsRepo extends MongoRepository<InvestmentDetails, Long>{

	
	@Query("{userId : ?0}")
    public List<InvestmentDetails> findByUserId(Long userId);
 
	@Query("{invId : ?0}")
	public InvestmentDetails findByInvId(Long invId);
	
	@Query("{invId : ?0}")
	public InvestmentDetails findByInvestmentId(Long invId);
	
	
}
