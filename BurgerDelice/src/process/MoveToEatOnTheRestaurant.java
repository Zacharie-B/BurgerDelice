package process;

import org.apache.log4j.Logger;

import data.Customer;
import data.PositionForEating;
import log.LoggerUtility;

public class MoveToEatOnTheRestaurant extends MoveCharacters{
	
	private Logger logger = LoggerUtility.getLogger(MoveToEatOnTheRestaurant.class, "process");
	
	/**
	 * Move the customer in order to eat on the restaurant.
	 * @param customer who eat on the restaurant 
	 * @param restaurantManager
	 */
	public void eatOnTable(Customer customer, RestaurantManager restaurantManager) {
		if(!customer.isEating()) {
			int nearestDistance = 100;
			// TODO Auto-generated method stub
			int lineDistance = 0;
			int columnDistance = 0;
			int currentDistance = 0;
			PositionForEating positionForEating = null;
			for(PositionForEating eating : restaurantManager.getPositionForEatings()) {
				if(eating != null) {
					if(!eating.isOccuped()) {
						int xDistance = customer.getPosition().getX() - eating.getX();
						int yDistance = customer.getPosition().getY() - eating.getY();
						currentDistance = Math.abs(xDistance) + Math.abs(yDistance);
						
						if(nearestDistance > currentDistance && currentDistance > 0) {
							lineDistance = xDistance;
							columnDistance = yDistance;
							nearestDistance = currentDistance;
							positionForEating = eating;
						}
					}	
				}
			}
			
			/** Move the customer to a place to eat on the place */
			if(Math.abs(lineDistance) > Math.abs(columnDistance)) {
				if(lineDistance > 0) {
					int error = moveLeftCollision(customer.getPosition(), restaurantManager);
					if(error == 1) 
						moveDownCollision(customer.getPosition(), restaurantManager);
				}
				else {
					int error = moveRightCollision(customer.getPosition(), restaurantManager);
					if(error == 1)
						moveDownCollision(customer.getPosition(), restaurantManager);
				}
			}
			else {
				if(columnDistance > 0) {
					int error = moveTopCollision(customer.getPosition(), restaurantManager);
					if(error == 1)
						moveLeftCollision(customer.getPosition(), restaurantManager);
				}
				else {
					int error = moveDownCollision(customer.getPosition(), restaurantManager);
					if(error == 1)
						moveRightCollision(customer.getPosition(), restaurantManager);
				}
			}
			
			/** if the customer is in a place where he can eat*/
			if((customer.getPosition().getX() == positionForEating.getX())
				&& (customer.getPosition().getY() == positionForEating.getY())) {
				customer.setEating(true);
				positionForEating.setOccuped(true);
			}
		}
		
		else if(customer.isEating()) {
			/**
			 * We check if the customer is still in the process of eating,
			 * if yes, he continue to eat his menu
			 * else he leaves out the restaurant.
			 */
			if(customer.getTimeForEat() > 0) {
				customer.setTimeForEat(customer.getTimeForEat() - 1);
			}
			else if(customer.getTimeForEat() == 0){
				customer.setOnTheRestaurant(false);
				/**
				 * We browse the list of all position where the customer can eat on the restaurant.
				 */
				for(PositionForEating eating : restaurantManager.getPositionForEatings()) {
					if(eating != null) {
						if(customer.getPosition().getX() == eating.getX() 
								&& customer.getPosition().getY() == eating.getY()) {
							eating.setOccuped(false);
						}
					}
				}
			}
		}
	}
}
