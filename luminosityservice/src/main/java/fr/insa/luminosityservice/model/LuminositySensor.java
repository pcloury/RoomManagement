package fr.insa.luminosityservice.model;

import java.util.Collections;

import org.eclipse.om2m.commons.obix.Bool;
import org.eclipse.om2m.commons.obix.Int;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.io.ObixDecoder;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class LuminositySensor {
	private String id; 
	private int luminosity;
	
	public LuminositySensor(String id) {
		this.id = id; 
		this.getLuminosity();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLuminosity() {
		RestTemplate restTemplate = new RestTemplate(); 

		HttpHeaders headers = new HttpHeaders(); 
		headers.set("X-M2M-ORIGIN", "admin:admin");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

		HttpEntity<String> entity = new HttpEntity<String>(headers); 
		String resourceURL = "http://127.0.0.1:8080/~/mn-cse/mn-name/"+id+"/DATA/la"; 
		ResponseEntity<String> respEntity = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class); 

		String resp = (String) respEntity.getBody();
		System.out.println("resp"+resp);
		
		Mapper mapper = new Mapper();
		
		//Convert from cin XML String to Cin object
		
		ContentInstance cin = (ContentInstance) mapper.unmarshal(resp);
		
	    //Convert the obix XML string (content of a cin object) to an object

		Obj obj = ObixDecoder.fromString(cin.getContent());  
		
		//Get the fourth object which corresponds to <bool val =”false” name=”state”>. The object index depends on your implementation. 

		Int obj1 = (Int) obj.getObjGroup().get(2); 
		
        System.out.println(obj1.getVal()); 
        this.luminosity = obj1.getVal().intValue(); 
		return luminosity; 
	}
	public void setLuminosity(int luminosity) {
		this.luminosity = luminosity;
	} 

}
