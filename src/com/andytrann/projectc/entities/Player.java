package com.andytrann.projectc.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.graphics.Animation;
import com.andytrann.projectc.graphics.Assets;
import com.andytrann.projectc.inventory.Inventory;

public class Player extends Character {

	private Animation run_right, run_left;
	private Animation idle;
	private Inventory inventory;
	public boolean canMove = true;

	public Player(Handler pHandler, float pX, float pY) {
		super(pHandler, pX, pY, 64, 64);
		
		// Collision Bounds
		bounds.height = 16;
		bounds.width = 30;
		bounds.x = 17;
		bounds.y = 48;
		
		// Animations
		run_right = new Animation(100, Assets.player_run_right);
		run_left = new Animation(100, Assets.player_run_left);
		idle = new Animation(1000, Assets.player_idle);
		
		// Inventory
		inventory = new Inventory(pHandler);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if(inventory.isActive())
			return;
		if(!canMove)
			return;
		
		speed = DEFAULT_SPEED;
		if (handler.getKeyManager().sprint)
			speed = 6.0f;
		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
	}
	
	public void postRender(Graphics g) {
		inventory.render(g);
	}

	@Override
	public void update() {
		run_right.update();
		run_left.update();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		inventory.update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getAnimFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
//		g.setColor(Color.red);
//		g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

	private BufferedImage getAnimFrame() {
		if (xMove != 0 || yMove != 0) {
			if (xMove > 0)
				return run_right.getCurrentFrame();
			else if (xMove < 0)
				return run_left.getCurrentFrame();
			else return idle.getCurrentFrame();
		} else
			return idle.getCurrentFrame();
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
}
