package fr.insa.heatingservice.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.heatingservice.model.Heating;

@RestController
@RequestMapping("/heating")
public class HeatingServiceResource {
	Heating heating = new Heating("Heating", true); 
	
	@GetMapping("/")
	public Heating getHeating() {
		return heating; 
	}
	
	@GetMapping(value="/{switchHeatingOn}", produces=MediaType.APPLICATION_XML_VALUE)
	public String setHeating(@PathVariable boolean switchHeatingOn){
		String res = heating.setOn(switchHeatingOn);
		return res; 
	}
}
