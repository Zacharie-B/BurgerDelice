package data;

import java.util.HashMap;

public class Order {

	private HashMap<String, Integer> basket = new HashMap<String, Integer>();
	private HashMap<String, Integer> order = new HashMap<String, Integer>();

	private int timeOrder = 0;

	private boolean isDelivering = false;
	private boolean isFinished = true;

	public Order() {
		super();
	}

	public void incrementTimeOrder() {
		timeOrder++;
	}

	public void buyBasket() {
		order = basket;
		basket = new HashMap<String, Integer>();
	}

	public HashMap<String, Integer> getBasket() {
		return basket;
	}

	public void setBasket(HashMap<String, Integer> basket) {
		this.basket = basket;
	}

	public HashMap<String, Integer> getOrder() {
		return order;
	}

	public void setOrder(HashMap<String, Integer> order) {
		this.order = order;
	}

	public int getTimeOrder() {
		return timeOrder;
	}

	public void setTimeOrder(int timeOrder) {
		this.timeOrder = timeOrder;
	}

	public boolean isDelivering() {
		return isDelivering;
	}

	public void setDelivering(boolean isDelivering) {
		this.isDelivering = isDelivering;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

}
