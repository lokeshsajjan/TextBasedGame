package com.company.cli;

import com.company.cli.Charactor.EnemyConfiguration;
import com.company.cli.Charactor.PlayerConfiguration;

public class GameState {
	private final EnemyConfiguration enemyConfiguration;
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
