package engine.mobile;

import engine.map.Block;

public class Oven extends Element{
	
	private int cookingTime;
	private int numberOfHotplate;
	
	public Oven(Block position, int cookingTime, int numberOfHotplate) {
		super(position);
		this.cookingTime = cookingTime;
		this.numberOfHotplate = numberOfHotplate;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}
	public int getNumberOfHotplate() {
		return numberOfHotplate;
	}
	public void setNumberOfHotplate(int numberOfHotplate) {
		this.numberOfHotplate = numberOfHotplate;
	}
	
	
}
