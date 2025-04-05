package com.venkateshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkateshit.request.UserDetailsRequest;
import com.venkateshit.request.UserLoginRequest;
import com.venkateshit.response.UserDetailsResponse;
import com.venkateshit.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;	
	
	@PostMapping(path = "/user/create")
	public String createUser(@RequestBody UserDetailsRequest userDetailsRequest) {
		
		System.out.println(userDetailsRequest);
		
		String result = userService.createUser(userDetailsRequest);
		
		// pass this info to service layer
		return result;
	}
	
	// user login
	
	@PostMapping(path = "/user/login")
	public UserDetailsResponse userLogin(@RequestBody UserLoginRequest userLoginRequest) {
		
		System.out.println(userLoginRequest);
		
		UserDetailsResponse response = userService.userLogin(userLoginRequest);
		
		return response;
		
	}

}
