package fr.insa.luminosityservice.model;

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
		luminosity = (int) Math.ceil(Math.random()*100);
		return luminosity; 
	}
	public void setLuminosity(int luminosity) {
		this.luminosity = luminosity;
	} 

}
