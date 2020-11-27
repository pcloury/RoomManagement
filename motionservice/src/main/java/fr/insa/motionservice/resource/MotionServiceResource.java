package fr.insa.motionservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/motion")
public class MotionServiceResource {
	
	@GetMapping("/value")
	public boolean getMotion() {
		if (Math.ceil(Math.random()*100)>50) {
			return true;
		}
		else {
			return false;
		}
	}
}
