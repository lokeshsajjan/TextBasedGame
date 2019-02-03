package com.company.cli.common;

import com.company.cli.GameState;

public interface ResourceManager {
	
	public void saveGame(GameState gameState);
	public GameState loadGame();

}
