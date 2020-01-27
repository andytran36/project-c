package com.andytrann.projectc.statics;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler pHandler, float pX, float pY, int pWidth, int pHeight) {
		super(pHandler, pX, pY, pWidth, pHeight);
	}
}
