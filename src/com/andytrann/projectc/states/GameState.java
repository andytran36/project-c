package com.andytrann.projectc.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.worlds.World;

public class GameState extends State {

	private World world;
	private Handler handler;

	public GameState(Handler pHandler) {
		super(pHandler);
		handler = pHandler;
		world = new World(pHandler, "start", 2);
		handler.setWorld(world);
	}

	@Override
	public void update() {
		world.update();
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE))
			State.setState(new BattleState(handler));
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
