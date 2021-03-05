package engine.mobile;

import engine.map.Block;

public class Customer extends Element{

	private int id;
	private int order;
	private boolean waitingOrder;
	private int timeWaiting = 0;
	
	public Customer(Block position, int id, boolean waitingOrder) {
		super(position);
		this.id = id;
		this.waitingOrder = waitingOrder;
		this.order = randomNumber();
	}
	
	public void incrementWaitingTime() {
		timeWaiting++;
	}

	public int getId() {
		return id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public boolean isWaitingOrder() {
		return waitingOrder;
	}

	public void setWaitingOrder(boolean waitingOrder) {
		this.waitingOrder = waitingOrder;
	}
	
	public int getTimeWaiting() {
		return timeWaiting;
	}

	public void setTimeWaiting(int timeWaiting) {
		this.timeWaiting = timeWaiting;
	}

	/**
	 * Allow to decides the menu choose by a customer.
	 * @return the number of the menu that customer will take
	 */
	public int randomNumber() {
		int randomNumber = (int) (Math.random() * 3);
		return randomNumber;
	}
	
}
