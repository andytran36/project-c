package com.andytrann.projectc.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.andytrann.projectc.Handler;

public class Item {

	public static final int ITEM_WIDTH = 16, ITEM_HEIGHT = 16;
	
	// Handler
	public static Item[] items = new Item[256];
	// public static Item woodItem = new Item(Assets.wood, "wood", 0);
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	protected int count, x, y;
	protected boolean pickedUp = false;

	public Item(BufferedImage pTexture, String pName, int pID) {
		texture = pTexture;
		name = pName;
		id = pID;
		count = 1;
		
		items[id] = this;
	}
	
	public void update() {

	}
	
	public Item createNew(int count) {
		Item i = new Item(texture, name, id);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}
	
	public void setPickedUp(boolean isPickedUp) {
		pickedUp = isPickedUp;
	}
	
	public void render(Graphics g) {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEM_WIDTH, ITEM_HEIGHT, null);
	}

	// Getters and Setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}
}
