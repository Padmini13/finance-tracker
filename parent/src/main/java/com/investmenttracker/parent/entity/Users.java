package com.investmenttracker.parent.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {
	
	    @Transient
	    public static final String SEQUENCE_NAME = "User_Sequence";
        @Id
	    private long userId;
	   
	    private String firstName;
	    
	    private String lastName;

	    @Indexed(unique = true)
	    private String emailId;
	    
	    @Indexed(unique = true)
	    private String PAN;
	    
	    @Indexed(unique = true)
	    private String phoneNumber;
	    
	    private String password;
	    
	    private String token;
	    
	    public Users() {
	    	
	    }
	    
	    public Users(int userId, String firstName, String lastName, String emailId, String PAN, String phoneNumber, String password) {
	    	super();
	    	this.userId = userId;
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.emailId = emailId;
	    	this.PAN = PAN;
	    	this.phoneNumber = phoneNumber;
	    	this.password = password;
	    }

		
		 public long getUserId() { 
			 return userId; 
			 }
		 
		 public void setUserId(long userId) { 
			 this.userId = userId;
			 }
		

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}


		public String getPAN() {
			return PAN;
		}

		public void setPAN(String pAN) {
			PAN = pAN;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

}
