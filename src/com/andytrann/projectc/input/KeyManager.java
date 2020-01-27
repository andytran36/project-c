package com.andytrann.projectc.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys, justPressed, noPress;
	public boolean up, down, left, right, sprint, interact;

	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		noPress = new boolean[keys.length];
	}

	public void update() {
		for (int i = 0; i < keys.length; i++) {
			if (noPress[i] && !keys[i]) {
				noPress[i] = false;
			} else if (justPressed[i]) {
				noPress[i] = true;
				justPressed[i] = false;
			}
			if (!noPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}

		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		sprint = keys[KeyEvent.VK_SHIFT];
		interact = keys[KeyEvent.VK_Z];
	}
	
	public boolean keyJustPressed(int keyCode) {
		if (keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

}
