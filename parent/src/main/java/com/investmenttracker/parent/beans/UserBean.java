package com.investmenttracker.parent.beans;

public class UserBean {
	
	
	    private long userId;
	    private String firstName;
	    private String lastName;
	    private String emailId;
	    private String panNumber;
	    private String phoneNumber;
	    private String password;
	    

		
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

		


		public String getPanNumber() {
			return panNumber;
		}

		public void setPanNumber(String panNumber) {
			this.panNumber = panNumber;
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
