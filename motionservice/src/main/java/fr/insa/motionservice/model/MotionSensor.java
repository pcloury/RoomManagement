package fr.insa.motionservice.model;

import java.util.Collections;

import org.eclipse.om2m.commons.obix.Bool;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.io.ObixDecoder;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MotionSensor {

	private String id; 
	private boolean isSomeonePresent; 

	public MotionSensor(String id){
		this.id = id; 
		this.isSomeonePresent();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isSomeonePresent() {
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

		Bool obj1 = (Bool) obj.getObjGroup().get(2); 
		
        System.out.println(obj1.getVal()); 
        isSomeonePresent = obj1.getVal(); 
		return isSomeonePresent; 
	}
	public void setSomeonePresent(boolean isSomeonePresent) {
		this.isSomeonePresent = isSomeonePresent;
	}

}
