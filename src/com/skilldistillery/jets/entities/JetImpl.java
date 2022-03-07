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
		output = this.model;
		output += " " + "with top speed: " + this.speedMph;
		output += " " + "and range: " + this.range;
		output += " " + "at price: " + this.price;
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

	@Override
	public void fight() {
		System.out.println("* Fighting! - " + model);
	}

	@Override
	public void fly() {
		String output;
		output = "* " + this.model;
		output += " is FLYING for " + this.range / this.speedMph + " hours";
		output += " " + "(" + this.range;
		output += " miles/" + this.speedMph + " MPH)";
		System.out.println(output);
	}

}
