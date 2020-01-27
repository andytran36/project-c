package com.andytrann.projectc.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.battle.Battle;

public class BattleState extends State {

	private Handler handler;
	private Battle battle;
	
	public BattleState(Handler pHandler) {
		super(pHandler);
		handler = pHandler;
		battle = new Battle(pHandler);
		handler.setBattle(battle);
	}

	@Override
	public void update() {
		battle.update();
	}

	@Override
	public void render(Graphics g) {
		battle.render(g);
	}

}
