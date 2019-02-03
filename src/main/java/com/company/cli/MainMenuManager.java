package com.company.cli;

import com.company.cli.adapter.exception.ConfigurationException;
import com.company.cli.menu.CliMainMenuImpl;
import com.company.cli.menu.MainMenu;
import com.company.cli.menu.MainMenuItem;
import com.company.cli.topic.RealmConfigurationGenerator;

public class MainMenuManager {
	private MainMenu mainMenu = new CliMainMenuImpl();

	public void showMenu() throws ConfigurationException {
		MainMenuItem choice;
		do {
			System.out.println("\nWelcome to Main Menu");
			choice = mainMenu.showMenu();
			switch (choice) {
			case START:
				System.out.println("You selected as " + choice);
				GameManager.newGame(RealmConfigurationGenerator.realms());
				break;
			case LOAD:
				GameManager.loadGame();
				break;
			case EXIT:
				System.out.println("You selected as " + choice);
				thankYouMessage();
				break;
			default:
				System.out.println("Should never happen");
			}
			

		} while (MainMenuItem.EXIT != choice);
	}

	private void thankYouMessage() {
		System.out.println("####################################");
		System.out.println("###  THANK YOU FOR PLAYING  ########");
		System.out.println("####################################");
	}
}
