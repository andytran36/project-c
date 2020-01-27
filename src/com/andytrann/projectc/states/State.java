package com.andytrann.projectc.states;

import java.awt.Graphics;

import com.andytrann.projectc.Handler;

public abstract class State {
	
	private static State currentState = null;
	
	protected Handler handler;
	
	public State(Handler pHandler) {
		handler = pHandler;
	}
	
	public static void setState(State pState) {
		currentState = pState;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}
