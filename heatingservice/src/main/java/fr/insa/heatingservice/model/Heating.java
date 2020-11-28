package fr.insa.heatingservice.model;

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
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	} 
	
	
}
