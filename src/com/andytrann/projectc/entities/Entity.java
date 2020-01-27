package com.andytrann.projectc.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.andytrann.projectc.Handler;

public abstract class Entity {

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;

	public Entity(Handler pHandler, float pX, float pY, int pWidth, int pHeight) {
		handler = pHandler;
		x = pX;
		y = pY;
		width = pWidth;
		height = pHeight;
		
		bounds = new Rectangle(0,0, width, height);
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e: handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void update();

	public abstract void render(Graphics g);
}
