package fr.insa.motionservice.resource;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.motionservice.model.MotionSensor;

@RestController
@RequestMapping("/motion")
public class MotionServiceResource {
	private MotionSensor sensor = new MotionSensor("MotionSensor");
	
	@GetMapping("/")
	public MotionSensor getSensor() {
		return sensor; 
	}
	
	@GetMapping("/value")
	public boolean getMotion() {
		return sensor.isSomeonePresent(); 
	}
}
