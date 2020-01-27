package com.andytrann.projectc.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.andytrann.projectc.Handler;

public class EntityManager {

	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity e1, Entity e2) {
			if (e1.getY() + e1.getHeight() < e2.getY() + e2.getHeight())
				return -1;
			return 1;
		}
	};

	public EntityManager(Handler pHandler, Player pPlayer) {
		handler = pHandler;
		player = pPlayer;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}

	public void update() {
		Iterator<Entity> iter = entities.iterator();
		while(iter.hasNext()) {
			Entity e = iter.next();
			e.update();
		}
		entities.sort(renderSorter);
	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
		player.postRender(g);
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
