package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	public List<Jet> airCommand = new ArrayList<>();

	public AirField() {
	}

	public void addAll(List<Jet> jets) {
		airCommand.addAll(jets);
	}

}
