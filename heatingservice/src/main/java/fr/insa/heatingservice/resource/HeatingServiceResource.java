package fr.insa.heatingservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heating")
public class HeatingServiceResource {
	int heat;
	
	@GetMapping(value="/{orderheat}")
	public void setHeating(@PathVariable int orderheat){
		this.heat = orderheat;
	}
}
