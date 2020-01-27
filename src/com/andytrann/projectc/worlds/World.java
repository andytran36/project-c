package com.andytrann.projectc.worlds;

import java.awt.Graphics;
import java.util.ArrayList;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.entities.EntityManager;
import com.andytrann.projectc.entities.Player;
import com.andytrann.projectc.items.ItemManager;
import com.andytrann.projectc.statics.Crystal;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int numLayers;
	private ArrayList<Layer> layers;

	// Managers
	private EntityManager entityManager;
	private ItemManager itemManager;

	public World(Handler pHandler, String pFileName, int pNumLayers) {
		handler = pHandler;
		numLayers = pNumLayers;
		layers = new ArrayList<Layer>();
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.addEntity(new Crystal(handler, 100, 100));

		itemManager = new ItemManager(handler);

		loadWorld(pFileName);

		spawnX = layers.get(0).getSpawnX();
		spawnY = layers.get(0).getSpawnY();
		width = layers.get(0).getWidth();
		height = layers.get(0).getHeight();
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}

	public void update() {
		for (Layer layer : layers) {
			layer.update();
		}
		itemManager.update();
		entityManager.update();
	}

	public void render(Graphics g) {
		for (Layer layer : layers) {
			layer.render(g);
		}
		itemManager.render(g);
		entityManager.render(g);
	}

	private void loadWorld(String fileName) {
		for (int i = 0; i <= numLayers; i++) {
			String path = "res/worlds/" + fileName + i + ".txt";
			layers.add(new Layer(handler, path));
		}
	}

	// Getters and Setters
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Layer getCollisionLayer() {
		return layers.get(0);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
