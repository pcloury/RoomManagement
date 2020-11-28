package fr.insa.controller.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/controller")
public class ControllerResource {
	private final String luminosityURL = "http://localhost:9090/luminosity/";
	private final String motionURL = "http://localhost:9091/motion/";
	private final String lightURL = "http://localhost:9092/light/";
	private final String heatingURL = "http://localhost:9093/heating/";


	@GetMapping("/run")
	public String run() {
		RestTemplate restTemplate = new RestTemplate();
		String msg = ""; 

		int luminosity = restTemplate.getForObject(luminosityURL+"value", Integer.class);
		msg+="<p>La luminosité est de " + luminosity+"</p>";

		boolean isSomeonePresent = restTemplate.getForObject(motionURL+"value", Boolean.class);
		msg+=isSomeonePresent ? "<p>Il y a des gens</p>" : "<p>Il n'y personne</p>";

		/*HttpHeaders headers = new HttpHeaders();
		headers.add("X-M2M-Origin","admin:admin");
		headers.add("Content-Type", "application/json;ty=4");
	    //HttpEntity<String> request = 
	    //	      new HttpEntity<String>(.toString(), headers);*/

		String lightRes = ""; 
		if (isSomeonePresent) {
		if (luminosity <33) {
			lightRes = restTemplate.getForObject(lightURL+"50", String.class); 
		} else if(luminosity >=33 && luminosity <66) {
			lightRes = restTemplate.getForObject(lightURL+"30", String.class);
		} else if(luminosity >=66) {
			lightRes = restTemplate.getForObject(lightURL+"0", String.class);
		}
		} else {
			lightRes = restTemplate.getForObject(lightURL+"0", String.class);
		}

		msg += lightRes;
		return msg; 

	}

}
