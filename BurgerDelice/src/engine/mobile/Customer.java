package engine.mobile;

import engine.map.Block;

public class Customer extends Element{

	private String name;
	private int order;
	private boolean waitingOrder;
	
	public Customer(Block position, String name, int order, boolean waitingOrder) {
		super(position);
		this.name = name;
		this.order = order;
		this.waitingOrder = waitingOrder;
	}

	public String getName() {
		return name;
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
	
}
