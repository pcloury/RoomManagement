package fr.insa.lightservice.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.lightservice.model.Light;

@RestController
@RequestMapping("/light")
public class LightServiceResource {
	private Light light = new Light("Light", 100); 

	@GetMapping("/")
	public Light getLight() {
		return light; 
	}
	
	@GetMapping(value="/{orderlight}", produces= MediaType.APPLICATION_XML_VALUE)
	public String setLight(@PathVariable int orderlight){
		String res = light.setLevel(orderlight);
		return res; 
	}

}
