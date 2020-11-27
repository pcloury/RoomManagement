package fr.insa.controller.resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller")
public class ControllerResource {
	private final String luminosityURL = "http://localhost:4200/luminosity/";
	private final String motionURL = "http://localhost:4200/motion/";
	private final String lightURL = "http://localhost:4200/light/";
	private final String heatingURL = "http://localhost:4200/heating/";
	

	@GetMapping("/run")
	public void run() {
		RestTemplate restTemplate = new RestTemplate();
		

		int luminosity = restTemplate.getForObject(luminosityURL+"value", Integer.class);
		System.out.println("la luminosity est de " + luminosity);
		
		int motion = restTemplate.getForObject(motionURL+"value", Integer.class);
		System.out.println("il y a des gens (0 ou 1) " + motion);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-M2M-Origin","admin:admin");
		headers.add("Content-Type", "application/json;ty=4");
	    //HttpEntity<String> request = 
	    //	      new HttpEntity<String>(.toString(), headers);
	    
		if (luminosity <33) {
			
			//String answer = restTemplate.postForObject(lightURL+"100", request, String.class);
			
		}
		else if(luminosity >=33 && luminosity <66) {
			
		}
		
		else if(luminosity >=66) {
			
		}
		
		
		
		
		
		
	}

}
