package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JetsApplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Create jets and populate airfield 
		JetsApplication app = new JetsApplication();
		app.readFromFile("jets.txt");
		
		// Populate airfield
		System.out.println("\nPopulating airfield...READY!\n");
		
		// Get command
		System.out.println("**** GREETINGS, COMMANDER! ****\n");
		app.greet();
		String selection = app.getSelection(sc);
		
		// Interact for user input
		while(true) {
			switch(selection) {
			case "1":
				System.out.println();
				System.out.println("\n1. List fleet:");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "2":
				System.out.println("\n2. Fly all jets");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "3":
				System.out.println();
				System.out.println("\n3. View fastest jet:");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "4":
				System.out.println("\n4. View jet with longest range");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "5":
				System.out.println();
				System.out.println("\n5. Load all Cargo Jets:");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "6":
				System.out.println("\n6. Dogfight!");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "7":
				System.out.println();
				System.out.println("\n7. Add a jet to Fleet:");
				System.out.println("* TBD");
				System.out.println();
				break;
			case "8":
				System.out.println("\n8. Remove a jet from Fleet");
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
	
	public void readFromFile(String fn) {
		System.out.println("Creating jets...\n");
	    try ( BufferedReader bufIn = new BufferedReader(new FileReader(fn)) ) {
	        String line;
	        while ((line = bufIn.readLine()) != null) {
	          System.out.println("... " + line);
	        }
	      }
	      catch (IOException e) {
	        System.err.println(e);
	      }
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
		}
		catch(Exception e) {
			System.out.println("Please make a valid selection.");
			return "help";
		}
		
		return selection;
	}

}
