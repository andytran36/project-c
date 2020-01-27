package com.andytrann.projectc.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.andytrann.projectc.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean mouseLeft, mouseRight;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager() {
		
	}
	
	public void setUIManager(UIManager pUIManager) {
		uiManager = pUIManager;
	}
	
	public boolean isLeftPressed() {
		return mouseLeft;
	}
	
	public boolean isRightPressed() {
		return mouseRight;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			mouseLeft = true;
		if (e.getButton() == MouseEvent.BUTTON2)
			mouseRight = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			mouseLeft = false;
		if (e.getButton() == MouseEvent.BUTTON2)
			mouseRight = false;
		
		if(uiManager != null)
			uiManager.onMouseRelease(e);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(uiManager != null)
			uiManager.onMouseMove(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
