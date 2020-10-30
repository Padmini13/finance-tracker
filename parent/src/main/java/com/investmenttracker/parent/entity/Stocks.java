package com.investmenttracker.parent.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocks")
public class Stocks {
 
	@Transient
	public static final String SEQUENCE_NAME = "Stocks_Sequence";
	@Id
	private Long stocksId;
	private String invsName;
	private String invsType;
	private Long currentPrice;
	private Long anticipatedGrowth;
	private Integer term;
	private Long quantity;
	@Autowired
	private Long userId;
	private String details;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getStocksId() {
		return stocksId;
	}
	public void setStocksId(Long stocksId) {
		this.stocksId = stocksId;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public String getInvsName() {
		return invsName;
	}
	public void setInvsName(String invsName) {
		this.invsName = invsName;
	}
	public String getInvsType() {
		return invsType;
	}
	public void setInvsType(String invsType) {
		this.invsType = invsType;
	}
	public Long getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Long currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Long getAnticipatedGrowth() {
		return anticipatedGrowth;
	}
	public void setAnticipatedGrowth(Long anticipatedGrowth) {
		this.anticipatedGrowth = anticipatedGrowth;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
