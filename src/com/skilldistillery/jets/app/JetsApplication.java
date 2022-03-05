package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class JetsApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Create jets and populate airfield
		JetsApplication app = new JetsApplication();
		List<Jet> jets = new ArrayList<>();
		jets = app.readFromFile("jets.txt");
		// System.out.println(jets); 

		// Populate airfield
		System.out.println("\nPopulating airfield...READY!\n");
		List<Jet> airCommand = jets;

		// Get command
		System.out.println("**** GREETINGS, COMMANDER! ****\n");
		app.greet();
		String selection = app.getSelection(sc);

		// Interact for user input
		while (true) {
			switch (selection) {
			case "1":
				System.out.println();
				System.out.println("\n1. List fleet:\n");
				for (Jet jet : airCommand) {
					System.out.println(jet);
				}

				System.out.println();
				break;
			case "2":
				System.out.println("\n2. Fly all jets:\n");
				for (Jet jet : airCommand) {
					System.out.println(jet.getModel() + " is flying at " + jet.getRange() + " MPH!");
				}
				System.out.println();
				break;
			case "3":
				System.out.println();
				System.out.println("\n3. View fastest jet:\n");
				Jet fastestJet = airCommand.get(0);
				
				for (int i = 1; i <= airCommand.size() - 1; i++) {
					if (airCommand.get(i).getSpeedMph() > fastestJet.getSpeedMph()) {
						fastestJet = airCommand.get(i);
					}
				}
				
				System.out.println(fastestJet);
				System.out.println();
				break;
			case "4":
				System.out.println("\n4. View jet with longest range:\n");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "5":
				System.out.println();
				System.out.println("\n5. Load all Cargo Jets:\n");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "6":
				System.out.println("\n6. Dogfight!\n");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "7":
				System.out.println();
				System.out.println("\n7. Add a jet to Fleet:\n");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "8":
				System.out.println("\n8. Remove a jet from Fleet\n");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "9":
				System.out.println("\n9. Quit\nQuitting program...\n");
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

	public List<Jet> readFromFile(String fn) {
		System.out.println("Creating jets...DONE!");
		List<Jet> jets = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fn))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				// System.out.println("... " + line);

				String[] inputLine = line.split(",");

				String name = inputLine[0];
				// System.out.println(name);

				int speed = Integer.parseInt(inputLine[1]);
				// System.out.println(speed);

				long range = Long.parseLong(inputLine[2]);
				// System.out.println(range);

				double price = Double.parseDouble(inputLine[3]);
				// System.out.println(price);

				Jet newJet = new JetImpl(name, speed, range, price);
				// System.out.println(newJet);
				jets.add(newJet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

	public void greet() {
		System.out.println("--\nWhat is your order?\n");
		System.out.println("MENU:");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Dogfight!");
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
