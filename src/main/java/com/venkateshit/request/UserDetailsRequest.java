package com.venkateshit.request;

import lombok.Data;

@Data
public class UserDetailsRequest {
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String mobileNumber;
	
	private String password;
	
	private int age;

}
