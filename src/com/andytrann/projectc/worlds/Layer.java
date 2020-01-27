package com.andytrann.projectc.worlds;

import java.awt.Graphics;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.tiles.Tile;
import com.andytrann.projectc.utils.Utils;

public class Layer {

	private int spawnX, spawnY;
	private Handler handler;
	private int width, height;
	private int[][] tiles;

	public Layer(Handler pHandler, String pPath) {
		handler = pHandler;
		loadLayer(pPath);
	}

	public void update() {
		
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.tiles.get(31);

		Tile t = Tile.tiles.get(tiles[x][y]);
		if (t == null)
			return Tile.tiles.get(31);
		return t;
	}
	
	private void loadLayer(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\W+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getSpawnX() {
		return spawnX;
	}
	
	public int getSpawnY() {
		return spawnY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
}
