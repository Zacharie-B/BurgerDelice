package data;

public class Customer extends Element {

	private int id;
	private int order;
	private boolean waitingOrder;
	private boolean onTheRestaurant;
	private int timeWaiting = 0;

	public Customer(Block position, int id, boolean waitingOrder, boolean onTheRestaurant) {
		super(position);
		this.id = id;
		this.waitingOrder = waitingOrder;
		this.onTheRestaurant = onTheRestaurant;
	}

	
	public boolean isOnTheRestaurant() {
		return onTheRestaurant;
	}

	public void setOnTheRestaurant(boolean onTheRestaurant) {
		this.onTheRestaurant = onTheRestaurant;
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

}