package com.andytrann.projectc.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import com.andytrann.projectc.Handler;
import com.andytrann.projectc.battle.Skill;
import com.andytrann.projectc.tiles.Tile;

public class Character extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 4.0f;
	public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;

	protected String name;
	protected int hp, hpMax, mp, mpMax;
	protected int physAtt, magAtt;
	protected ArrayList<Skill> skills;
	protected float xMove, yMove;
	protected float speed;
	protected boolean dead = false;

	public Character(Handler pHandler, float pX, float pY, int pWidth, int pHeight) {
		super(pHandler, pX, pY, pWidth, pHeight);
		hp = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		if (!checkEntityCollisions(xMove, 0f))
			moveX();
		if (!checkEntityCollisions(0f, yMove))
			moveY();
	}

	public void moveX() {
		if (xMove > 0) {
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
		} else if (xMove < 0) {
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}
		}
	}

	public void moveY() {
		if (yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
			}
		} else if (yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}
		}
	}

	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getCollisionLayer().getTile(x, y) == Tile.tiles.get(0)? true : false;
	}

	public void addSkill(Skill pSkill) {
		skills.add(pSkill);
	}

	public void useSkill(Character opponent, Skill skill) {
		int damage = (int) (physAtt * skill.getAttMult() + magAtt * skill.getMagMult());
		opponent.takeDamage(damage);
	}

	public void takeDamage(int damage) {
		if (hp > 0) {
			hp -= damage;
			if (hp <= 0) {
				dead = true;
			}
		}
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("HP: [" + hp + "/" + hpMax + "]" + " MP: [" + mp + "/" + mpMax + "]");
		System.out.println("PhysATT: [" + physAtt + "]" + " MagATT: [" + physAtt + "]");
		for (int i = 0; i < skills.size(); i++) {
			System.out.println("Skills:");
			System.out.println((i + 1) + ": " + skills.get(i).getSkillName());
		}
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {

	}

	// Getters and Setters
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
		this.hp = hpMax;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMpMax() {
		return mpMax;
	}

	public void setMpMax(int mpMax) {
		this.mpMax = mpMax;
		this.mp = mpMax;
	}

	public int getPhysAtt() {
		return physAtt;
	}

	public void setPhysAtt(int physAtt) {
		this.physAtt = physAtt;
	}

	public int getMagAtt() {
		return magAtt;
	}

	public void setMagAtt(int magAtt) {
		this.magAtt = magAtt;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	
}
