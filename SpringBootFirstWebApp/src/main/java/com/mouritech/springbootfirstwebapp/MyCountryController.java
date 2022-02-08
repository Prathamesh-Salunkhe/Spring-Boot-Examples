package com.mouritech.springbootfirstwebapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MyCountryController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String returnCountryName() {
		return "ILove India";
	}
}
