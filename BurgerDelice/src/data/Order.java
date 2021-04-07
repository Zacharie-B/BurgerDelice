package data;

import java.util.HashMap;

public class Order {

	private HashMap<String, Integer> basket = new HashMap<String, Integer>();
	private HashMap<String, Integer> order = new HashMap<String, Integer>();

	public Order() {
		super();
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

	public void addBasket(String name) {
		if (basket.get(name) == null) {
			basket.put(name, 1);
		} else {
			basket.put(name, basket.get(name) + 1);
		}
	}

	public void buyBasket() {
		order = basket;
		basket = new HashMap<String, Integer>();

	}

}
