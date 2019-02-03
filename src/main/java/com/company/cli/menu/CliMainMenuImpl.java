package com.company.cli.menu;

import java.util.Scanner;

import com.company.cli.adapter.exception.UserInputParseException;

public class CliMainMenuImpl implements MainMenu {
	private final Scanner scanner=new Scanner(System.in);
	public MainMenuItem showMenu() {
		printAllOptions();
		return selectOption();
	}

	private MainMenuItem selectOption() {
		 int result = Integer.parseInt(scanner.nextLine());
		 if(MainMenuItem.values().length<result) {
			throw new UserInputParseException("Sorry, but command number is either below 0 or too high. Please try again");
		 }
		return MainMenuItem.values()[result-1];
	}

	private void printAllOptions() {
		System.out.println("Please choose one of those options:");
		int counter=1;
		 for (MainMenuItem item: MainMenuItem.values()) {
			 System.out.println(counter+"."+item);
			 counter++;
	        }

	}

}
