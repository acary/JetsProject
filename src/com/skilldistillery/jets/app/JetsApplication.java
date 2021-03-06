package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Cargo;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.Drone;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class JetsApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in).useDelimiter("\n")) {

			// Create aircraft and populate airfield
			JetsApplication app = new JetsApplication();

			// Jets
			List<Jet> jets = new ArrayList<>();
			jets = app.readJetFromFile("jets.txt");

			// Cargo
			List<Cargo> cargo = new ArrayList<>();
			cargo = app.readCargoFromFile("cargo.txt");

			// Drones
			List<Drone> drones = new ArrayList<>();
			drones = app.readDronesFromFile("drones.txt");

			// Populate airfield
			System.out.println("Populating airfield...READY!\n");
			AirField airField = new AirField();
			airField.airCommand.addAll(jets);
			airField.airCommand.addAll(cargo);
			airField.airCommand.addAll(drones);

			// Get command
			System.out.println("**** GREETINGS, COMMANDER! ****\n");
			app.greet();
			String selection = app.getSelection(sc);

			// Interact for user input
			while (true) {
				switch (selection) {
				case "1":
					System.out.println();
					System.out.println("***************************");
					System.out.println("1. List fleet:\n");
					for (Jet jet : airField.airCommand) {
						System.out.println("* " + jet);
					}
					System.out.println();
					break;
				case "2":
					System.out.println();
					System.out.println("***************************");
					System.out.println("2. Fly all jets:\n");
					for (Jet jet : airField.airCommand) {
						jet.fly();
					}
					System.out.println();
					break;
				case "3":
					System.out.println();
					System.out.println("***************************");
					System.out.println("3. View fastest jet:\n");
					Jet fastestJet = null;
					try {
						fastestJet = airField.airCommand.get(0);
					} catch (Exception e) {
						System.out.println("An error occurred.\n");
						break;
					}
					if (fastestJet != null) {
						for (int i = 1; i < airField.airCommand.size(); i++) {
							if (airField.airCommand.get(i).getSpeedMph() > fastestJet.getSpeedMph()) {
								fastestJet = airField.airCommand.get(i);
							}
						}
						System.out.println(
								"* Fastest jet: " + fastestJet.getModel() + " @ " + fastestJet.getSpeedMph() + " MPH");
					}
					System.out.println();
					break;
				case "4":
					System.out.println();
					System.out.println("***************************");
					System.out.println("4. View jet with longest range:\n");
					Jet farthestJet = null;
					try {
						farthestJet = airField.airCommand.get(0);
					} catch (Exception e) {
						System.out.println("An error occurred.\n");
						break;
					}
					if (airField.airCommand != null) {
						for (int i = 1; i < airField.airCommand.size(); i++) {
							if (airField.airCommand.get(i).getRange() > farthestJet.getRange()) {
								farthestJet = airField.airCommand.get(i);
							}
						}
						System.out.println("* Longest range jet: " + farthestJet.getModel() + " @ "
								+ farthestJet.getRange() + " miles");
					}
					System.out.println();
					break;
				case "5":
					System.out.println();
					System.out.println("***************************");
					System.out.println("5. Set drone laser and frequency:\n");
					String color;
					int freq;
					
					System.out.println("Enter new laser color:");
					try {
						color = sc.next();
					} catch (Exception e) {
						System.out.println("An error occurred.\n");
						break;
					}
					System.out.println("Enter new frequency integer:");
					try {
						freq = sc.nextInt();
					} catch (Exception e) {
						System.out.println("An error occurred.\n");
						break;
					}
					
					for (Jet drone : airField.airCommand) {
						if (drone instanceof Drone) {
							((Drone) drone).setFreqAndLaser(color, freq);
						}
					}

					System.out.println("Lasers and frequency set to: " + color + ", " + freq);
					System.out.println();
					break;
				case "6":
					System.out.println();
					System.out.println("***************************");
					System.out.println("6. Drone offensive!\n");
					for (Jet jet : airField.airCommand) {
						if (jet instanceof Drone) {
							jet.fight();
						}
					}
					System.out.println();
					break;
				case "7":
					System.out.println();
					System.out.println("***************************");
					System.out.println("7. Add a jet to Fleet:\n");
					String name;
					int speed;
					long range;
					double price;
					System.out.println("Enter new jet model (name):");
					try {
						name = sc.next();
					} catch (Exception e) {
						System.out.println("An error occurred.\n");
						break;
					}
					System.out.println("Enter new jet speed (MPH):");
					try {
						speed = sc.nextInt();
					} catch (Exception e) {
						System.out.println("An error occurred.\n");
						break;
					}
					System.out.println("Enter new jet range (miles):");
					try {
						range = sc.nextLong();
					} catch (Exception e) {
						System.out.println("An error occurred.\n");
						break;
					}
					System.out.println("Enter new jet price (USD):");
					try {
						price = sc.nextDouble();
					} catch (Exception e) {
						System.out.println("An error occurred.\n");
						break;
					}
					System.out.println();
					Jet newJet = new JetImpl(name, speed, range, price);
					airField.airCommand.add(newJet);
					System.out.println("Added!");
					for (Jet jet : airField.airCommand) {
						System.out.println("* " + jet);
					}
					System.out.println();
					break;
				case "8":
					System.out.println();
					System.out.println("***************************");
					System.out.println("8. Remove a jet from Fleet\n");

					System.out.println("Available jets:\n");

					for (int i = 0; i < airField.airCommand.size(); i++) {
						System.out.println(i + ": " + airField.airCommand.get(i));
					}

					int toRemove;

					System.out.println("\nWhich jet to remove?\n");
					try {
						toRemove = sc.nextInt();
					} catch (Exception e) {
						System.out.println("\nUh oh, something happened.\n");
						System.out.println("\nWhich jet to remove?\n");
						toRemove = sc.nextInt();
					}

					try {
						airField.airCommand.remove(toRemove);
						System.out.println("Removed.\n");
						for (Jet jet : airField.airCommand) {
							System.out.println("* " + jet);
						}
					} catch (Exception e) {
						System.out.println("Hmmm, please try again.");
					}

					System.out.println();
					break;
				case "9":
					System.out.println();
					System.out.println("***************************");
					System.out.println("9. Quit\nQuitting program...\n");
					System.exit(0);
				case "help":
					break;
				default:
					System.out.println("\nPlease make a valid selection.\n");
				}
				app.greet();
				selection = app.getSelection(sc);
			}
		}
	}

	public List<Jet> readJetFromFile(String fn) {
		System.out.println("Creating jets...DONE!");
		List<Jet> jets = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fn))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] inputLine = line.split(",");
				String name = inputLine[0];
				int speed = Integer.parseInt(inputLine[1]);
				long range = Long.parseLong(inputLine[2]);
				double price = Double.parseDouble(inputLine[3]);
				Jet newJet = new JetImpl(name, speed, range, price);
				jets.add(newJet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

	public List<Cargo> readCargoFromFile(String fn) {
		System.out.println("Creating cargo carriers...DONE!");
		List<Cargo> cargo = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fn))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] inputLine = line.split(",");
				String name = inputLine[0];
				int speed = Integer.parseInt(inputLine[1]);
				long range = Long.parseLong(inputLine[2]);
				double price = Double.parseDouble(inputLine[3]);
				Cargo newCargo = new CargoCarrier(name, speed, range, price);
				cargo.add(newCargo);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return cargo;
	}
	
	public List<Drone> readDronesFromFile(String fn) {
		System.out.println("Creating drones...DONE!");
		List<Drone> drone = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fn))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] inputLine = line.split(",");
				String name = inputLine[0];
				int speed = Integer.parseInt(inputLine[1]);
				long range = Long.parseLong(inputLine[2]);
				double price = Double.parseDouble(inputLine[3]);
				Drone newDrone = new Drone(name, speed, range, price);
				drone.add(newDrone);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return drone;
	}

	public void greet() {
		System.out.println("--\nWhat is your order?\n");
		System.out.println("MENU:");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Set drone laser and frequency");
		System.out.println("6. Drone offensive!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Quit");
	}

	public String getSelection(Scanner sc) {

		String selection = null;

		try {
			selection = sc.next();
		} catch (Exception e) {
			System.out.println("Please make a valid selection.");
			return "help";
		}

		return selection;
	}

}
