package fr.insa.lightservice.model;

public class Light {
	private String id;
	private int level;
	
	

	public Light(String id, int level) {
		this.id = id; 
		this.level = level; 
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	

}
