
package com.investmenttracker.parent.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_investment_details")
public class InvestmentDetails {

	 @Transient
	 public static final String SEQUENCE_NAME = "Invsetment_Details_Sequence";
	@Id
	private Long invId;
	private Long userId;
	private String invsName;
	private String invsType;
	private Long quantity;
	private Long costPrice;
	private Long currentPrice;
	@Transient
	private Long percentage;
	public Long getInvId() {
		return invId;
	}
	public void setInvId(Long invId) {
		this.invId = invId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Long costPrice) {
		this.costPrice = costPrice;
	}
	public Long getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Long currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Long getPercentage() {
		return percentage;
	}
	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}

		
}
