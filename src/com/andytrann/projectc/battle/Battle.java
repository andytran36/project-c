package com.andytrann.projectc.battle;

import java.awt.Graphics;

import com.andytrann.projectc.Handler;

public class Battle {

	private BattleScreen battleScreen;
	
	public Battle(Handler pHandler) {
		battleScreen = new BattleScreen(pHandler, "battle", 3);
	}
	
	public void update() {
		battleScreen.update();
	}
	
	public void render(Graphics g) {
		battleScreen.render(g);
	}
	
}
