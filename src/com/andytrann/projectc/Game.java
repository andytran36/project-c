package com.andytrann.projectc;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.andytrann.projectc.display.Display;
import com.andytrann.projectc.graphics.Assets;
import com.andytrann.projectc.graphics.GameCamera;
import com.andytrann.projectc.input.KeyManager;
import com.andytrann.projectc.input.MouseManager;
import com.andytrann.projectc.states.BattleState;
import com.andytrann.projectc.states.GameState;
import com.andytrann.projectc.states.MainMenuState;
import com.andytrann.projectc.states.State;

public class Game implements Runnable {

	// Display
	private Display display;
	private String title;
	private int width, height;
	private boolean isRunning = false;

	// Threading
	private Thread thread;

	// Render
	private BufferStrategy bs;
	private Graphics g;

	// States
	public State gameState;
	public State mainMenuState;
	public State battleState;

	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	// Camera
	private GameCamera gameCamera;
	
	// Handler
	private Handler handler;

	public Game(String pTitle, int pWidth, int pHeight) {
		title = pTitle;
		width = pWidth;
		height = pHeight;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		mainMenuState = new MainMenuState(handler);
		battleState = new BattleState(handler);
		State.setState(mainMenuState);
	}

	public void run() {

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		long ticks = 0;

		init();

		isRunning = true;
		while (isRunning) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("FPS: " + ticks);
				timer = 0;
				ticks = 0;
			}
		}

		stop();
	}

	private void update() {
		keyManager.update();
		if (State.getState() != null) {
			State.getState().update();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw to screen
		if (State.getState() != null) {
			State.getState().render(g);
		}

		// End
		bs.show();
		g.dispose();

	}

	public synchronized void start() {
		if (!isRunning) {
			isRunning = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	public synchronized void stop() {
		if (!isRunning)
			return;
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
