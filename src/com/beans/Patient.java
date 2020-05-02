package com.beans;

public class Patient {

	private String name;
	private float temperature;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public Patient(String name, float temperature) {
		super();
		this.name = name;
		this.temperature = temperature;
	}
	
	public String toString() {
		return name + temperature;
	}
	
	
	
}
