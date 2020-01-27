package com.andytrann.projectc.battle;

import java.awt.Graphics;
import java.util.ArrayList;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.entities.Enemy;
import com.andytrann.projectc.entities.EntityManager;
import com.andytrann.projectc.entities.Player;
import com.andytrann.projectc.worlds.Layer;

public class BattleScreen {

	private Handler handler;
	private ArrayList<Layer> layers;
	private int numLayers;
	private Enemy enemy;
	private BattleUI battleUI;
	
	private EntityManager entityManager;

	public BattleScreen(Handler pHandler, String pFileName, int pNumLayers) {
		handler = pHandler;
		numLayers = pNumLayers;
		layers = new ArrayList<Layer>();
		entityManager = new EntityManager(handler, new Player(handler, 500, 200));
		entityManager.getPlayer().canMove = false;
		
		enemy = new Enemy(pHandler, 700, 100, 120, 123);
		enemy.setName("Eagle");
		enemy.setHpMax(50);
		enemy.setMpMax(30);
		entityManager.addEntity(enemy);
		
		battleUI = new BattleUI(handler, enemy);
		
		loadScreen(pFileName);
	}

	public void update() {
		for (Layer layer : layers) {
			layer.update();
		}
		entityManager.update();
		battleUI.update();
	}

	public void render(Graphics g) {
		for (Layer layer : layers) {
			layer.render(g);
		}
		entityManager.render(g);
		battleUI.render(g);
	}

	public void loadScreen(String fileName) {
		for (int i = 1; i <= numLayers; i++) {
			String path = "res/battle/" + fileName + i + ".txt";
			layers.add(new Layer(handler, path));
		}
	}

}
