package com.investmenttracker.parent.entity;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class InvestmentDetailSequenceGenerator {
	
	private MongoOperations mongoOperations;

	@Autowired
	    public InvestmentDetailSequenceGenerator(MongoOperations mongoOperations) {
	        this.mongoOperations = mongoOperations;
	    }

	public long generateSequence(String seqName) {

		InvestmentDetailSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), InvestmentDetailSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() + 100 : 1;

	}

}
