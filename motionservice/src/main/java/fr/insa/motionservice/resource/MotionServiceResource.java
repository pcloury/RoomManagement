package fr.insa.motionservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.motionservice.model.MotionSensor;

@RestController
@RequestMapping("/motion")
public class MotionServiceResource {
	private MotionSensor sensor = new MotionSensor("motion1");
	
	@GetMapping("/")
	public MotionSensor getSensor() {
		return sensor; 
	}
	
	@GetMapping("/value")
	public boolean getMotion() {
		return sensor.isSomeonePresent(); 
	}
}
