package com.andytrann.projectc.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.andytrann.projectc.tiles.Tile;

public class Assets {

	public static final int SHEETX = 29, SHEETY = 21;
	public static final int WIDTH = 16, HEIGHT = 16;
	public static final int PLAYER_WIDTH = 24, PLAYER_HEIGHT = 24;

	public static Font font16;
	public static Font font32;

	public static BufferedImage[] player_run_right, player_idle, player_run_left, start, enemy, cursor;
	public static ArrayList<BufferedImage> tiles;
	public static BufferedImage inventoryScreen, battleUI, bar;

	public static void init() {
		font16 = FontLoader.loadFont("res/fonts/font.ttf", 16);
		font32 = FontLoader.loadFont("res/fonts/font.ttf", 32);

		tiles = new ArrayList<BufferedImage>();
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/tileset.png"));
		for (int y = 0; y < SHEETY; y++) {
			for (int x = 0; x < SHEETX; x++) {
				tiles.add(sheet.crop(x * 16, y * 16, 16, 16));
			}
		}

		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/gabe-anim.png"));
		player_run_right = new BufferedImage[6];
		player_run_right[0] = sheet.crop(PLAYER_WIDTH, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_right[1] = sheet.crop(2 * PLAYER_WIDTH, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_right[2] = sheet.crop(3 * PLAYER_WIDTH, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_right[3] = sheet.crop(4 * PLAYER_WIDTH, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_right[4] = sheet.crop(5 * PLAYER_WIDTH, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_right[5] = sheet.crop(6 * PLAYER_WIDTH, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_left = new BufferedImage[6];
		player_run_left[0] = sheet.crop(0, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_left[1] = sheet.crop(1 * PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_left[2] = sheet.crop(2 * PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_left[3] = sheet.crop(3 * PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_left[4] = sheet.crop(4 * PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_run_left[5] = sheet.crop(5 * PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT);
		player_idle = new BufferedImage[1];
		player_idle[0] = sheet.crop(0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);

		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet2.png"));
		start = new BufferedImage[2];
		start[0] = sheet.crop(0, 0, 32, 16);
		start[1] = sheet.crop(0, 16, 32, 16);
		cursor = new BufferedImage[2];
		cursor[0] = sheet.crop(32, 0, 16, 16);
		cursor[1] = sheet.crop(32, 16, 16, 16);
		bar = sheet.crop(0, 32, 80, 16);

		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/enemy-anim.png"));
		enemy = new BufferedImage[4];
		enemy[0] = sheet.crop(0, 0, 40, 41);
		enemy[1] = sheet.crop(40, 0, 40, 41);
		enemy[2] = sheet.crop(80, 0, 40, 41);
		enemy[3] = sheet.crop(120, 0, 40, 41);

		sheet = new SpriteSheet(ImageLoader.loadImage("/ui/battleui.png"));
		battleUI = sheet.crop(0, 0, 240, 64);
		Tile.init();
	}
}
