package com.investmenttracker.parent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.investmenttracker.parent.entity.Users;

public interface UserRepository extends MongoRepository<Users, Long>{
	
	@Query("{emailId : ?0}")
    public Users findByEmailId(String emailId);
	
	 @Query("{ 'emailId' : ?0 }, { 'password' : ?1")
	public Users findByEmailIdAndPassword(String emailId, String password);

}
