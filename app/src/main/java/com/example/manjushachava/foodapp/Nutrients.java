package com.example.manjushachava.foodapp;

public class Nutrients {	
	private String name;
	private String measurement;
	private double value;
	private double percentage;
	
//Superclass for Lipids, Minerals, Vitamins, and Proximates

	/**
	 * creates an instance of the Nutrients object
	 */
	public Nutrients(){
		
	}

	/**
	 *
	 * @return the name of the nutrient
	 */
	public String getName() {
		return name;
	}


	/**
	 * sets the name of the nutrient
	 * @param name the name of the nutrient
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 *
	 * @return the measurement of each nutrient
	 */
	public String getMeasurement() {
		return measurement;
	}


	/**
	 * sets the name of the measurement
	 * @param measurement the name of the measurement
	 */
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}


	/**
	 *
	 * @return the value of the nutrient
	 */
	public double getValue() {
		return value;
	}


	/**
	 * sets the value of each nutrient
	 * @param value the amount of each nutrient
	 */
	public void setValue(double value) {
		this.value = value;
	}


	/**
	 *
	 * @return the percentage of each nutrient
	 */
	public double getPercentage() {
		return percentage;
	}


	/**
	 * sets the percentage of each nutrient
	 * @param percentage the percentage of each nutrient
	 */
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	

}
