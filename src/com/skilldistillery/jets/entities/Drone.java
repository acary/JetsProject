package com.skilldistillery.jets.entities;

public class Drone extends Jet implements Autonomous, Shielded {

	private String model;
	private int speedMph;
	private long range;
	private double price;
	private String laser = "green";
	private int frequency = 7;

	public Drone() {
	}

	public Drone(String model, int speedMph, long range, double price) {
		super();
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
	public String getModel() {
		return model;
	}

	@Override
	public long getRange() {
		return range;
	}

	@Override
	public int getSpeedMph() {
		return speedMph;
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

	@Override
	public void fight() {
		System.out.println("* Fighting " + model + " with " + getLaser() + " laser " + "at frequency: " + this.frequency);
	}

	public void changeLaser(String color) {
		this.setLaser(color);
	}

	public void changeFrequency(int freq) {
		this.setFrequency(freq);
	}

	public String getLaser() {
		return laser;
	}

	public void setLaser(String laser) {
		this.laser = laser;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public void setFreqAndLaser(String color, int freq) {
		laser = color;
		frequency = freq;
	}

}
