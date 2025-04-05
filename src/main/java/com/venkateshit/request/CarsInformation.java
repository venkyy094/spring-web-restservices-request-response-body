package com.venkateshit.request;

import java.util.List;

import lombok.Data;


@Data
public class CarsInformation {
	
	
	private String brandName;
	
	private List<CarsInfo> carsInfo;

}
