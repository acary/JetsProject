package com.skilldistillery.jets.entities;

public abstract class Cargo extends Jet {
	String model;
	int speedMph;
	long range;
	double price;
	
	public Cargo() {
	}
	
	public String getModel;

	public double setModel;

	public int getSpeedMph;

	public int setSpeedMph;

	public long getRange;

	public long setRange;

	public double getPrice;

	public double setPrice;
	
	public abstract String toString();

	public abstract String getModel();
	
	public abstract long getRange();

	public abstract int getSpeedMph();
	
	public abstract void loadCargo();
}
