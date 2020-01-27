package com.andytrann.projectc.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

	private BufferedImage[] images;
	private ClickListener clickListener;

	public UIImageButton(float pX, float pY, int pWidth, int pHeight, BufferedImage[] pImages,
			ClickListener pClickListener) {
		super(pX, pY, pWidth, pHeight);
		images = pImages;
		clickListener = pClickListener;
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		if (hovering)
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		clickListener.onClick();
	}

}
