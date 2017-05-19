package com.example.manjushachava.foodapp;

public class Nutrients {	
	private String name;
	private String measurement;
	private double value;
	private double percentage;
	
//Superclass for Lipids, Minerals, Vitamins, and Proximates

	
	public Nutrients(){
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMeasurement() {
		return measurement;
	}


	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	

}
