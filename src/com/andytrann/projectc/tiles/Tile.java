package com.andytrann.projectc.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.andytrann.projectc.graphics.Assets;

public class Tile {

	public static ArrayList<Tile> tiles;

	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

	protected BufferedImage texture;

	public Tile(BufferedImage pTexture) {
		texture = pTexture;
	}

	public void update() {
	}

	public static void init() {
		tiles = new ArrayList<Tile>();
		for (BufferedImage bi : Assets.tiles) {
			tiles.add(new Tile(bi));
		}
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}
}
