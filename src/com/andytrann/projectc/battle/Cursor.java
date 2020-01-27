package com.andytrann.projectc.battle;

import java.awt.Graphics;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.graphics.Animation;
import com.andytrann.projectc.graphics.Assets;

public class Cursor {

	private Handler handler;
	private Animation texture;

	public Cursor(Handler pHandler) {
		handler = pHandler;
		texture = new Animation(500, Assets.cursor);
	}

	public void update() {
		texture.update();
	}

	public void render(Graphics g, int selected) {
		g.drawImage(texture.getCurrentFrame(), BattleUI.x + 24, BattleUI.y + 24 + 32 * (selected + 1), 32, 32, null);
	}

}
