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
	private final String windowsURL = "http://localhost:9094/windows/";

	@GetMapping("/run")
	public String run() {
		RestTemplate restTemplate = new RestTemplate();
		String msg = "<p>Voici les informations fournies pas les capteurs :</p>"; 

		int luminosity = restTemplate.getForObject(luminosityURL+"value", Integer.class);
		msg+="<p>La luminosité est de " + luminosity+"</p>";

		boolean isSomeonePresent = restTemplate.getForObject(motionURL+"value", Boolean.class);
		msg+=isSomeonePresent ? "<p>Il y a des gens</p>" : "<p>Il n'y personne</p>";

		boolean isWindowOpen = restTemplate.getForObject(windowsURL+"value", Boolean.class);
		msg+=isWindowOpen ? "<p>La fenêtre est ouverte</p>" : "<p>La fenêtre est fermée</p>";

		/*HttpHeaders headers = new HttpHeaders();
		headers.add("X-M2M-Origin","admin:admin");
		headers.add("Content-Type", "application/json;ty=4");
	    //HttpEntity<String> request = 
	    //	      new HttpEntity<String>(.toString(), headers);*/


		msg+= "<br><p>On effectue donc les actions suivantes :</p>"; 
		String lightLevel = ""; 
		if (isSomeonePresent) {
			if (luminosity <33) {
				lightLevel = "80";
				restTemplate.getForObject(lightURL+lightLevel, String.class);  
			} else if(luminosity >=33 && luminosity <66) {
				lightLevel = "50"; 
				restTemplate.getForObject(lightURL+lightLevel, String.class);
			} else if(luminosity >=66) {
				lightLevel = "10"; 
				restTemplate.getForObject(lightURL+lightLevel, String.class);	
			}
		} else {
			lightLevel = "0"; 
			restTemplate.getForObject(lightURL+lightLevel, String.class);
		}

		if (isWindowOpen) {
			restTemplate.getForObject(heatingURL+"false", String.class); 
			msg += "<p>On éteint le chauffage</p>";
		}

		msg += "<p>On met la lumière à "+lightLevel+"</p>";
		return msg; 

	}

}
