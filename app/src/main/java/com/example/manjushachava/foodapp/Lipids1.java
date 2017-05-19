package com.example.manjushachava.foodapp;

public class Lipids1 {
	private double fat_sat;
	private double fat_mono;
	private double fat_poly;
	private double cholestrl;

	/**
	 * creates an instance of the Lipids1 object
	 */
	public Lipids1() {

	}

	/**
	 *
	 * @return the amount of saturated fat
	 */
	public double getFat_sat() {
		return fat_sat;
	}

	/**
	 * sets the amount of saturated fat
	 * @param fat_sat
	 */
	public void setFat_sat(double fat_sat) {
		this.fat_sat = fat_sat;
	}

	/**
	 *
	 * @return the amount of monosaturated fat
	 */
	public double getFat_mono() {
		return fat_mono;
	}

	/**
	 * sets the amount of monosaturated fat
	 * @param fat_mono
	 */
	public void setFat_mono(double fat_mono) {
		this.fat_mono = fat_mono;
	}

	/**
	 *
	 * @return the amount of polysaturated fat
	 */
	public double getFat_poly() {
		return fat_poly;
	}

	/**
	 * sets the amount of polysaturated fat
	 * @param fat_poly
	 */
	public void setFat_poly(double fat_poly) {
		this.fat_poly = fat_poly;
	}

	/**
	 *
	 * @return the amount of cholesterol
	 */
	public double getCholestrl() {
		return cholestrl;
	}

	/**
	 * sets the amount of cholesterol
	 * @param cholestrl
	 */
	public void setCholestrl(double cholestrl) {
		this.cholestrl = cholestrl;
	}
}
