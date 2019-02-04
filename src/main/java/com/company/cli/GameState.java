package com.company.cli;

import com.company.cli.Charactor.EnemyConfiguration;
import com.company.cli.Charactor.PlayerConfiguration;

/**
 * @author lsajjan
 * used to save or load the game 
 * contains player and enemy information
 *
 */
public class GameState {
	private final EnemyConfiguration enemyConfiguration;
	/**
	 * 
	 */
	private final PlayerConfiguration playerConfiguration;

	public GameState(PlayerConfiguration playerConfiguration, EnemyConfiguration enemyConfiguration) {
		this.playerConfiguration = playerConfiguration;
		this.enemyConfiguration = enemyConfiguration;
	}

	

	public EnemyConfiguration getEnemyConfiguration() {
		return enemyConfiguration;
	}

	public PlayerConfiguration getPlayerConfiguration() {
		return playerConfiguration;
	}

}
