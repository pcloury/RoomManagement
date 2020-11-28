package fr.insa.motionservice.model;

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
		if (Math.ceil(Math.random()*100)>50) {
			isSomeonePresent = false; 
		}
		else {
			isSomeonePresent = true; 
		}
		return isSomeonePresent; 
	}
	public void setSomeonePresent(boolean isSomeonePresent) {
		this.isSomeonePresent = isSomeonePresent;
	}

}
