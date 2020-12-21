package fr.insa.windowsservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.windowsservice.model.WindowsSensor;

@RestController
@RequestMapping("/windows")
public class WindowsServiceResource {
	private WindowsSensor sensor = new WindowsSensor("WindowsSensor"); 

	@GetMapping("/")
	public WindowsSensor getSensor() {
		return sensor; 
	}
	
	@GetMapping("/value")
	public boolean getIsWindowOpen() {
		return sensor.isWindowOpen(); 
	}
}
