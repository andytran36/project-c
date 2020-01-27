package com.andytrann.projectc.statics;

import java.awt.Graphics;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.graphics.Assets;
import com.andytrann.projectc.tiles.Tile;

public class Crystal extends StaticEntity {

	public Crystal(Handler pHandler, float pX, float pY) {
		super(pHandler, pX, pY, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.width = 64;
		bounds.height = 32;
		bounds.x = 0;
		bounds.y = 32;
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tiles.get(118), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
