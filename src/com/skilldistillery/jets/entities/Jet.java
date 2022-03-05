package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private int speedMph;
	private long range;
	private double price;
	
	public Jet() {
	}
	
	public Jet(String model, int speedMph, long range, double price) {
		this.model = model;
		this.speedMph = speedMph;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeedMph() {
		return speedMph;
	}

	public void setSpeedMph(int speedMph) {
		this.speedMph = speedMph;
	}

	public long getRange() {
		return range;
	}

	public void setRange(long range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public abstract String toString();
}
