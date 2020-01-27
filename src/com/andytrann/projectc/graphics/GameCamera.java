package com.andytrann.projectc.graphics;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.entities.Entity;
import com.andytrann.projectc.tiles.Tile;

public class GameCamera {

	private Handler handler;
	private float xOffset, yOffset;

	public GameCamera(Handler pHandler, float pXOffset, float pYOffset) {
		handler = pHandler;
		xOffset = pXOffset;
		yOffset = pYOffset;
	}

	public void checkBlank() {
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
		}

		if (yOffset < 0) {
			yOffset = 0;
		} else if (yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
		}
	}

	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlank();
	}

	public void move(float xAmount, float yAmount) {
		xOffset += xAmount;
		yOffset += yAmount;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
