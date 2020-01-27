package com.andytrann.projectc.battle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.entities.Enemy;
import com.andytrann.projectc.graphics.Assets;
import com.andytrann.projectc.graphics.Text;
import com.andytrann.projectc.states.State;

public class BattleUI {

	private Handler handler;
	private BufferedImage base;
	private Cursor cursor;
	private Enemy enemy;
	public static final int x = 160, y = 524, width = 960, height = 192;
	private int selected = 0;

	public BattleUI(Handler pHandler, Enemy pEnemy) {
		handler = pHandler;
		enemy = pEnemy;
		base = Assets.battleUI;
		cursor = new Cursor(handler);
	}

	public void select() {
		if (selected == 0) {
			enemy.takeDamage(10);
			if(enemy.isDead())
				State.setState(handler.getGame().gameState);
		} else if (selected == 1) {

		} else if (selected == 2) {

		} else if (selected == 3) {

		}
	}
	
	public void update() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {
			select();
			return;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)) {
			selected--;
		} else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)) {
			selected++;
		}
		if (selected < 0)
			selected = 3;
		if (selected > 3)
			selected = 0;
		cursor.update();		
	}

	public void render(Graphics g) {
		g.drawImage(base, x, y, width, height, null);
		Text.drawString(g, enemy.getName(), x + 32, y + 48, false, Color.white, Assets.font32);
		Text.drawString(g, "FIGHT", x + 64, y + 48 + 32, false, Color.white, Assets.font16);
		Text.drawString(g, "MAGIC", x + 64, y + 48 + 32 * 2, false, Color.white, Assets.font16);
		Text.drawString(g, "ITEMS", x + 64, y + 48 + 32 * 3, false, Color.white, Assets.font16);
		Text.drawString(g, "FLEE", x + 64, y + 48 + 32 * 4, false, Color.white, Assets.font16);
		
		Text.drawString(g, "PARTY", x + 352, y + 48, false, Color.white, Assets.font32);
		Text.drawString(g, "PLAYER", x + 384, y + 80, false, Color.yellow, Assets.font16);
		Text.drawString(g, "HP", x + 510, y + 80, false, Color.white, Assets.font16);
		Text.drawString(g, "MP", x + 730, y + 80, false, Color.white, Assets.font16);
		g.drawImage(Assets.bar, x + 540, y + 58, 160, 32, null);
		g.drawImage(Assets.bar, x + 760, y + 58, 160, 32, null);
		cursor.render(g, selected);
	}
}
