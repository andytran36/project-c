package com.andytrann.projectc;

import com.andytrann.projectc.battle.Battle;
import com.andytrann.projectc.graphics.GameCamera;
import com.andytrann.projectc.input.KeyManager;
import com.andytrann.projectc.input.MouseManager;
import com.andytrann.projectc.worlds.World;

public class Handler {

	private Game game;
	private World world;
	private Battle battle;

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public Handler(Game pGame) {
		game = pGame;
	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
