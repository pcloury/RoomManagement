package fr.insa.roomManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class Luminosity {
	double lampIntensity;
	double ambiantLuminosity;
	

	public Luminosity() {
		ambiantLuminosity =  Math.random();	
	}
	
	@GetMapping("/getLuminosity")
	public double getLuminosity() {
		ambiantLuminosity =  Math.random();
		return ambiantLuminosity;
	}
	
	@GetMapping(value="/setLuminosity/{givenLampIntensity}")
	public void setLuminosity(@PathVariable int givenLampIntensity) {
		lampIntensity = givenLampIntensity;
	}
	
	

}
