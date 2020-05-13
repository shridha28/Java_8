package com.beans;

public class Patient implements Comparable<Patient>{

	private String name;
	private Double temperature;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Patient(String name, Double temperature) {
		super();
		this.name = name;
		this.temperature = temperature;
	}
	
	public String toString() {
		return name + temperature;
	}
	@Override
	public int compareTo(Patient o) {
		
		return this.getName().compareTo(o.getName());
	}
	
	
	
}
