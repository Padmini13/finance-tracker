package com.investmenttracker.parent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.investmenttracker.parent.entity.Stocks;

public interface StocksRepository extends MongoRepository<Stocks, Long> {

	@Query("{invsName : ?0}")
	Stocks findByInvsName(String name);

}
