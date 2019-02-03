package com.company.cli.TextBasedGame;

import org.junit.Test;

import com.company.cli.GameManager;
import com.company.cli.GameState;
import com.company.cli.Charactor.EnemyConfiguration;
import com.company.cli.Charactor.PlayerConfiguration;
import com.company.cli.adapter.exception.ConfigurationException;
import com.company.cli.common.ResourceManager;
import com.company.cli.common.ResourceManagerImpl;
import com.company.cli.topic.RealmConfigurationGenerator;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */

public class GameTest {

	@Test
	public void loadGameSuccessTest() throws ConfigurationException {
		try {
			ResourceManager resourceManager = new ResourceManagerImpl();
			PlayerConfiguration playerConfiguration2 = new PlayerConfiguration("test", "testdesc", 100, 10);
			EnemyConfiguration enemyConfiguration = new EnemyConfiguration("testEnemy", "testEnemyDesc", "hhh", 100, 1,
					0);
			GameState gameState = new GameState(playerConfiguration2, enemyConfiguration);

			resourceManager.saveGame(gameState);
			GameState GameState = resourceManager.loadGame();
			Assert.assertNotNull(GameState);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void saveGameTest() throws ConfigurationException {
		try {
			ResourceManager resourceManager = new ResourceManagerImpl();
			PlayerConfiguration playerConfiguration2 = new PlayerConfiguration("test", "testdesc", 100, 10);
			EnemyConfiguration enemyConfiguration = new EnemyConfiguration("testEnemy", "testEnemyDesc", "hhh", 100, 1,
					0);
			GameState gameState = new GameState(playerConfiguration2, enemyConfiguration);

			resourceManager.saveGame(gameState);

			Assert.assertNotNull(ResourceManagerImpl.savedGame);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getEnemyTest() throws ConfigurationException {
		EnemyConfiguration randomEnemy=GameManager.getEnemyForFight(RealmConfigurationGenerator.realms().get(0));
		Assert.assertNotNull(randomEnemy);
	}

}
