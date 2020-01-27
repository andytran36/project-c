package com.andytrann.projectc.states;

import java.awt.Color;
import java.awt.Graphics;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.graphics.Assets;
import com.andytrann.projectc.graphics.Text;
import com.andytrann.projectc.ui.ClickListener;
import com.andytrann.projectc.ui.UIImageButton;
import com.andytrann.projectc.ui.UIManager;

public class MainMenuState extends State {

	private UIManager uiManager;

	public MainMenuState(Handler pHandler) {
		super(pHandler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton((pHandler.getWidth() - 128) / 2, (pHandler.getHeight() - 64) / 2, 128, 64,
				Assets.start, new ClickListener() {
					@Override
					public void onClick() {
						handler.getMouseManager().setUIManager(null);
						State.setState(handler.getGame().gameState);
					}
				}));

	}

	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 1280, 720);

		Text.drawString(g, "Project C", handler.getWidth() / 2, 200, true, Color.white,
				Assets.font32);
		uiManager.render(g);
	}

}
