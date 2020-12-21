package fr.insa.heatingservice.model;

import java.util.Collections;

import org.eclipse.om2m.commons.obix.Bool;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.io.ObixDecoder;
import org.eclipse.om2m.commons.obix.io.ObixEncoder;
import org.eclipse.om2m.commons.obix.io.ObixMapper;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class Heating {
	private String id; 
	private boolean isOn;
	
	public Heating(String id, boolean isOn) {
		this.id = id; 
		this.isOn = isOn; 
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isOn() {
		return isOn;
	}
	public String setOn(boolean isOn) {
		this.isOn = isOn;
		
		ContentInstance cin = new ContentInstance(); 
	
		Obj obj = new Obj(); 
		obj.getObjGroup().add((Object) isOn);
		
		cin.setContent(ObixEncoder.toString(obj));
		System.out.println("obj"+obj);
		
		Mapper mapper = new Mapper();
		String body = mapper.marshal(cin); 
		System.out.println("body"+body);
		RestTemplate restTemplate = new RestTemplate(); 
		
		HttpHeaders headers = new HttpHeaders(); 
		headers.set("X-M2M-ORIGIN", "admin:admin");
		headers.set("Content-Type", "application/xml;ty=4");

		HttpEntity<String> entity = new HttpEntity<String>(body, headers); 
		String resourceURL = "http://127.0.0.1:8080/~/mn-cse/mn-name/"+id+"/DATA"; 
		ResponseEntity<String> respEntity = restTemplate.exchange(resourceURL, HttpMethod.POST, entity, String.class); 

		String resp = (String) respEntity.getBody();
		return resp; 

	} 
	
	
}
