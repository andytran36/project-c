package com.andytrann.projectc.entities;

import java.awt.Graphics;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.graphics.Animation;
import com.andytrann.projectc.graphics.Assets;

public class Enemy extends Character {

	private Animation anim;

	public Enemy(Handler pHandler, float pX, float pY, int pWidth, int pHeight) {
		super(pHandler, pX, pY, pWidth, pHeight);
		anim = new Animation(100, Assets.enemy);
	}

	public void update() {
		anim.update();
	}

	public void render(Graphics g) {
		g.drawImage(anim.getCurrentFrame(), (int) x, (int) y, width, height, null);
	}

}
