package com.company.cli;

import com.company.cli.adapter.exception.ConfigurationException;
import com.company.cli.menu.CliMainMenuImpl;
import com.company.cli.menu.MainMenu;
import com.company.cli.menu.MainMenuItem;
import com.company.cli.topic.RealmConfigurationGenerator;

/**
 * @author lsajjan
 *Main manager to manage the Menus
 */
public class MainMenuManager {
	private MainMenu mainMenu = new CliMainMenuImpl();

	/**Displays the Main menu to choose option for next step
	 * @throws ConfigurationException
	 */
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

	/**
	 * Thank you message to say Thanks to players
	 * this will execute once game is end or player quit the game
	 */
	private void thankYouMessage() {
		System.out.println("####################################");
		System.out.println("###  THANK YOU FOR PLAYING  ########");
		System.out.println("####################################");
	}
}
