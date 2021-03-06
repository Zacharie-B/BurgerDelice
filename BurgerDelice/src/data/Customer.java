package data;
/**
 * 
 * this class represent the element customer on the map
 *
 */
public class Customer extends Element {
	/**
	 * id is the number assigned to a customer
	 */
	private int id;
	private int order;
	private boolean waitingOrder;
	private boolean onTheRestaurant;
	private boolean eating = false;
	private boolean happiness = true;
	private int timeWaiting = 0;
	private int timeForEat;

	public Customer(Block position, int id, int order, boolean waitingOrder, boolean onTheRestaurant, int timeForEat) {
		super(position);
		this.id = id;
		this.order = order;
		this.waitingOrder = waitingOrder;
		this.onTheRestaurant = onTheRestaurant;
		this.timeForEat = timeForEat;
	}
	
	public int getTimeForEat() {
		return timeForEat;
	}

	public void setTimeForEat(int timeForEat) {
		this.timeForEat = timeForEat;
	}

	public boolean isOnTheRestaurant() {
		return onTheRestaurant;
	}

	public void setOnTheRestaurant(boolean onTheRestaurant) {
		this.onTheRestaurant = onTheRestaurant;
	}

	public void incrementWaitingTime() {
		this.timeWaiting++;
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
	
	public boolean isEating() {
		return eating;
	}

	public void setEating(boolean eating) {
		this.eating = eating;
	}

	public int getTimeWaiting() {
		return timeWaiting;
	}

	public void setTimeWaiting(int timeWaiting) {
		this.timeWaiting = timeWaiting;
	}

	public boolean isHappiness() {
		return happiness;
	}

	public void setHappiness(boolean happiness) {
		this.happiness = happiness;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", order=" + order + ", waitingOrder=" + waitingOrder + ", onTheRestaurant="
				+ onTheRestaurant + ", eating=" + eating + ", timeWaiting=" + timeWaiting + ", timeForEat=" + timeForEat
				+ "]";
	}
}
