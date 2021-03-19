package process;

import data.Block;
import data.Customer;

public class MoveToEatOnTheRestaurant extends MoveCharacters{

	/**
	 * Move the customer in order to eat on the restaurant.
	 * @param customer
	 * @param restaurantManager
	 */
	public void eatOnTable(Customer customer, RestaurantManager restaurantManager) {
		if(!customer.isEating()) {
			int nearestdistance = 0;
			// TODO Auto-generated method stub
			int lineDistance = 0;
			int columnDistance = 0;
			int currentDistance = 0;
			Block nearestBlock;
			for(Block eating : restaurantManager.getPositionForEatings()) {
				lineDistance = customer.getPosition().getX() - eating.getX();
				columnDistance = customer.getPosition().getY() - eating.getY();
				currentDistance = Math.abs(lineDistance) + Math.abs(columnDistance);
				if(nearestdistance > currentDistance) {
					nearestBlock = eating;
				}
			}
			
			if(Math.abs(lineDistance) > Math.abs(columnDistance)) {
				if(lineDistance > 0) {
					moveLeftCollision(customer.getPosition(), restaurantManager);
				}
				else {
					moveRightCollision(customer.getPosition(), restaurantManager);
				}
			}
			else {
				if(columnDistance > 0) {
					moveTopCollision(customer.getPosition(), restaurantManager);
				}
				else {
					moveDownCollision(customer.getPosition(), restaurantManager);
				}
			}
		}
		else if(customer.isEating()) {
			if(customer.getTimeForEat() > 0) {
				customer.setTimeForEat(customer.getTimeForEat() - 1);
			}
			else if(customer.getTimeForEat() == 0){
				customer.setOnTheRestaurant(false);
			}
		}
	}
}
