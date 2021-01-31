package engine.mobile;

import engine.map.Block;

public class Storage extends Element{ 
	
	private int capacityMax;
	private int currentCapacity;
	private String name;
	
	public Storage(Block position, int capacityMax, int currentCapacity, String name) {
		super(position);
		this.capacityMax = capacityMax;
		this.currentCapacity = currentCapacity;
		this.name = name;
	}

	public int getCapacityMax() {
		return capacityMax;
	}

	public void setCapacityMax(int capacityMax) {
		this.capacityMax = capacityMax;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
