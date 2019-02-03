package com.company.cli.common;

import java.util.HashMap;
import java.util.Map;

import com.company.cli.GameState;
import com.company.cli.Charactor.EnemyConfiguration;
import com.company.cli.Charactor.PlayerConfiguration;

public class ResourceManagerImpl implements ResourceManager {
	public static Map<Object, Object> savedGame = null;

	@Override
	public GameState loadGame() {
		if (savedGame != null) {
			GameState gameState = new GameState((PlayerConfiguration) savedGame.get("PLAYER"),
					(EnemyConfiguration) savedGame.get("ENEMEY"));
			savedGame = null;
			return gameState;
		} else {
			return null;
		}
	}

	@Override
	public void saveGame(GameState gameState) {
		savedGame = new HashMap<>();
		savedGame.put("PLAYER", gameState.getPlayerConfiguration());
		savedGame.put("ENEMEY", gameState.getEnemyConfiguration());

	}

}
