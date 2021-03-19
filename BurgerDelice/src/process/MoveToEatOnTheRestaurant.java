package process;

import org.apache.log4j.Logger;

import data.Block;
import data.Customer;
import log.LoggerUtility;

public class MoveToEatOnTheRestaurant extends MoveCharacters{
	
	private Logger logger = LoggerUtility.getLogger(MoveToEatOnTheRestaurant.class, "process");
	/**
	 * Move the customer in order to eat on the restaurant.
	 * @param customer
	 * @param restaurantManager
	 */
	public void eatOnTable(Customer customer, RestaurantManager restaurantManager) {
		if(!customer.isEating()) {
			int nearestDistance = 100;
			// TODO Auto-generated method stub
			int lineDistance = 0;
			int columnDistance = 0;
			int currentDistance = 0;
			Block nearestBlock;
			for(Block eating : restaurantManager.getPositionForEatings()) {
				lineDistance = customer.getPosition().getX() - eating.getX();
				columnDistance = customer.getPosition().getY() - eating.getY();
				currentDistance = Math.abs(lineDistance) + Math.abs(columnDistance);
				
				logger.info("distance avec la position pour manger : " + nearestDistance);
				if(nearestDistance > currentDistance) {
					nearestDistance = currentDistance;
					nearestBlock = eating;
				}
			}
			
			logger.info("distance : " + nearestDistance);
			if(nearestDistance == 0) {
				customer.setEating(true);
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
