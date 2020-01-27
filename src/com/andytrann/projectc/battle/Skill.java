package com.andytrann.projectc.battle;

public class Skill {
	
	private String skillName;
	private int mpCost;
	private double attMult, magMult;
	
	public Skill(String pSkillName, int pMPCost, double pAttMult, double pMagMult) {
		skillName = pSkillName;
		mpCost = pMPCost;
		attMult = pAttMult;
		magMult = pMagMult;
		
	}
	
	public String getSkillName() {
		return skillName;
	}

	public int getMpCost() {
		return mpCost;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public void setMpCost(int mpCost) {
		this.mpCost = mpCost;
	}

	public void setAttMult(double attMult) {
		this.attMult = attMult;
	}

	public void setMagMult(double magMult) {
		this.magMult = magMult;
	}

	public double getAttMult() {
		return attMult;
	}

	public double getMagMult() {
		return magMult;
	}
	
}
