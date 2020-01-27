package com.andytrann.projectc.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import com.andytrann.projectc.Handler;

public class ItemManager {

	private Handler handler;
	private ArrayList<Item> items;
	
	public ItemManager(Handler pHandler) {
		handler = pHandler;
		items = new ArrayList<Item>();
	}
	
	public void update() {
		Iterator<Item> iter= items.iterator();
		while(iter.hasNext()) {
			Item i = iter.next();
			i.update();
		}
	}
	
	public void render(Graphics g) {
		for(Item i: items)
			i.render(g);
	}
	
	public void addItem(Item e) {
		items.add(e);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
