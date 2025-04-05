package com.venkateshit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkateshit.request.CarsInfo;
import com.venkateshit.request.CarsInformation;

@RestController
public class ProductController {
	
	@PostMapping(path = "/cars/info")
	public String getCarsInfo(@RequestBody List<CarsInfo> carsInfo) {
		
		carsInfo.forEach(System.out::println);
		
		
		return "Car's information received";
		
	}
	
	@PostMapping(path = "/cars/brand/info")
	public String carsOfBrand(@RequestBody CarsInformation carsInformation) {
		
		System.out.println(carsInformation.getBrandName());
		System.out.println(carsInformation.getCarsInfo());
		
		return "Car's information received";
		
	}
	

}
