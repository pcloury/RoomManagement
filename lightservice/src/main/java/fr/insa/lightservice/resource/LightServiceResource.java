package fr.insa.lightservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heating")
public class LightServiceResource {
	int light;

	@GetMapping(value="/{orderlight}")
	public void setLight(@PathVariable int orderlight){
		this.light = orderlight;
	}

}
