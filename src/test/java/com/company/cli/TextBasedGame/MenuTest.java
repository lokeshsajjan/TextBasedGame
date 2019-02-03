package com.company.cli.TextBasedGame;

import java.util.ArrayList;

import org.junit.Test;

import com.company.cli.Charactor.RealmConfiguration;
import com.company.cli.adapter.exception.ConfigurationException;
import com.company.cli.menu.MainMenuItem;
import com.company.cli.topic.RealmConfigurationGenerator;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class MenuTest {

	@Test
	public void mainMenuItemTest() throws ConfigurationException {
		int menuItemLenght = MainMenuItem.values().length;
		MainMenuItem value = MainMenuItem.values()[menuItemLenght - 1];
		Assert.assertEquals("EXIT", value.name());
	}
	@Test
	public void topicMenuTest() throws ConfigurationException {
		ArrayList<RealmConfiguration> realms=RealmConfigurationGenerator.realms();
		Assert.assertEquals("Grand Theft Auto", realms.get(0).getName());
	}
	

}
