package fr.insa.lightservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.lightservice.model.Light;

@RestController
@RequestMapping("/light")
public class LightServiceResource {
	private Light light = new Light("light1", 100); 

	@GetMapping("/")
	public Light getLight() {
		return light; 
	}
	
	@GetMapping(value="/{orderlight}")
	public String setLight(@PathVariable int orderlight){
		light.setLevel(orderlight);
		return "<p>La lampe a été mise au niveau "+orderlight+"</p>"; 
	}

}
