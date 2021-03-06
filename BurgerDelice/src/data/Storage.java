package data;
/**
* This class contain the composition of of the storage.
* 
* 
*
*/
public class Storage extends Element{ 

    /**
     * The stock limit for each product.
     */
	private int capacityMax;
    /**
    * The current capacity of each product.
    */
	private int currentCapacity;
	/**
    * The name of the product.
    */
	private String name;
	
	public Storage(Block position, int capacityMax, int currentCapacity, String name) {
		super(position);
		this.capacityMax = capacityMax;
		this.currentCapacity = currentCapacity;
		this.name = name;
	}
	
	public void decrementCapacity(int capacity) {
		this.currentCapacity -= capacity;
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

	@Override
	public String toString() {
		return "Storage [capacityMax=" + capacityMax + ", currentCapacity=" + currentCapacity + ", name=" + name + "]";
	}
	
	
}
