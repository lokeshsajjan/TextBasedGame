package com.company.cli.common;

import java.util.HashMap;
import java.util.Map;

import com.company.cli.GameState;
import com.company.cli.Charactor.EnemyConfiguration;
import com.company.cli.Charactor.PlayerConfiguration;

/**
 * @author lsajjan
 *
 */
public class ResourceManagerImpl implements ResourceManager {
	public static Map<Object, Object> savedGame = null;

	/* load the saved game
	 * @see com.company.cli.common.ResourceManager#loadGame()
	 */
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

	/* Save the player game
	 * @see com.company.cli.common.ResourceManager#saveGame(com.company.cli.GameState)
	 */
	@Override
	public void saveGame(GameState gameState) {
		savedGame = new HashMap<>();
		savedGame.put("PLAYER", gameState.getPlayerConfiguration());
		savedGame.put("ENEMEY", gameState.getEnemyConfiguration());

	}

}
