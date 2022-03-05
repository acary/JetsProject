package com.skilldistillery.jets.entities;

public class JetImpl extends Jet {
	
	private String model;
	private int speedMph;
	private long range;
	private double price;
	
	public JetImpl() {
	}
	
	public JetImpl(String model, int speedMph, long range, double price) {
		this.model = model;
		this.speedMph = speedMph;
		this.range = range;
		this.price = price;
	}

	@Override
	public String toString() {
		String output;
		// output = model + " " + speedMph + " " + range + " " + price;
		output = this.model;
		output += " " + "with top speed: " + this.speedMph;
		output += " " + " and range: " + this.range;
		output += " " + " at price: " + this.price;
		return output;
	}

	@Override
	public long getRange() {
		return range;
	}

	@Override
	public String getModel() {
		return model;
	}

	@Override
	public int getSpeedMph() {
		return speedMph;
	}

}
