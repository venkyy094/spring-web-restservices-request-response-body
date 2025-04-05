package com.venkateshit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkateshit.entity.UserDetails;
import com.venkateshit.repository.UserRepository;
import com.venkateshit.request.UserDetailsRequest;
import com.venkateshit.request.UserLoginRequest;
import com.venkateshit.response.UserDetailsResponse;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;

	public String createUser(UserDetailsRequest userDetailsRequest) {
		
		//pass entity object
		// data mapping/ data transfer from one object to another object
		
		UserDetails userData = new UserDetails();
		
		userData.setEmailId(userDetailsRequest.getEmailId());
		userData.setFirstName(userDetailsRequest.getFirstName());
		userData.setLastName(userDetailsRequest.getLastName());
		userData.setMobileNumber(userDetailsRequest.getMobileNumber());
		userData.setPassword(userDetailsRequest.getPassword());
		userData.setAge(userDetailsRequest.getAge());		
		
		if (userRepository.findById(userDetailsRequest.getEmailId()).isEmpty()) {
			userRepository.save(userData);
			return "User Created Successfully. ";
		}

		return "User Already existed with same email.";	

	}

	public UserDetailsResponse userLogin(UserLoginRequest userLoginRequest) {
		
		UserDetails userData = userRepository.findByEmailIdAndPassword(userLoginRequest.getEmailId(), userLoginRequest.getPassword());
		UserDetailsResponse userDetails = new UserDetailsResponse();
		if(userData!= null) {
			
			
			//map data from entity to DTO object
			
			userDetails.setEmailId(userData.getEmailId());
			userDetails.setFirstName(userData.getFirstName());
			userDetails.setLastName(userData.getLastName());
			userDetails.setMobileNumber(userData.getMobileNumber());			
			userDetails.setAge(userData.getAge());
			return userDetails;
		}else {
			return null;
		}
		
		
				
		
	}
	
}