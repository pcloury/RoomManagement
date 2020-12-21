package fr.insa.luminosityservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.luminosityservice.model.LuminositySensor;

@RestController
@RequestMapping("/luminosity")
public class LuminosityResource {
	
	private LuminositySensor sensor = new LuminositySensor("LuminositySensor"); 

	@GetMapping("/")
	public LuminositySensor getSensor() {
		return sensor; 
	}
	
	@GetMapping("/value")
	public int getLuminosity() {
		return sensor.getLuminosity(); 
	}

}
