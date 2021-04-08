package data;

/**
 * 
 * 
 *
 */
public class Checkout extends Element {

	private float capacityMax;
	private float currentMoney;

	public Checkout(Block position, float capacityMax, float currentMoney) {
		super(position);
		this.capacityMax = capacityMax;
		this.currentMoney = currentMoney;
	}

	public float getCapacityMax() {
		return capacityMax;
	}

	public void setCapacityMax(float capacityMax) {
		this.capacityMax = capacityMax;
	}

	public float getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(float currentMoney) {
		this.currentMoney = currentMoney;
	}

}
