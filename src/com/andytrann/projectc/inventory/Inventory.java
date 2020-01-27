package com.andytrann.projectc.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.graphics.Assets;
import com.andytrann.projectc.items.Item;

public class Inventory {

	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;

	public Inventory(Handler pHandler) {
		handler = pHandler;
		inventoryItems = new ArrayList<Item>();
	}

	public void update() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if (!active)
			return;
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP));
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN));
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT));
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT));
	}

	public void render(Graphics g) {
		if (!active)
			return;
		g.drawImage(Assets.inventoryScreen, 100, 100, 100, 100, null);
		g.setColor(Color.black);
		g.fillRect(200, 100, 1000, 600);
		int len = inventoryItems.size();
		if(len == 0)
			return;
		
	}

	public void addItem(Item item) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}
	
	
}
