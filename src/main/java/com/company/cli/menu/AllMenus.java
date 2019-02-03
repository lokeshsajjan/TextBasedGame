package com.company.cli.menu;

public class AllMenus {
	private final MainMenu mainMenu;

	public AllMenus(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public MainMenu mainMenu() {
		return mainMenu;
	}
}
