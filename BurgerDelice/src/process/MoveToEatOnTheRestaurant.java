package process;

import org.apache.log4j.Logger;

import data.Block;
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
			Block nearestBlock = null;
			for(PositionForEating eating : restaurantManager.getPositionForEatings()) {
				if(eating != null) {
					if(!eating.isOccuped()) {
						int xDistance = customer.getPosition().getX() - eating.getX();
						int yDistance = customer.getPosition().getY() - eating.getY();
						currentDistance = Math.abs(xDistance) + Math.abs(yDistance);
						
						logger.info("Client n°" + customer.getId() + " à la distance la plus proche : " + currentDistance); 
						
						if(nearestDistance > currentDistance && currentDistance > 0) {
							lineDistance = xDistance;
							columnDistance = yDistance;
							nearestDistance = currentDistance;
							nearestBlock = eating;
						}
					}
				}
			}
			logger.info("Le client n°" + customer.getId() + " va à la place " + nearestBlock.toString());
			
			if(nearestDistance == 100) {
				customer.setEating(true);
				for(PositionForEating eating : restaurantManager.getPositionForEatings()) {
					if(eating != null) {
						if(nearestBlock.equals(eating)) {
							eating.setOccuped(true);
							logger.info("La place " + eating.toString() + "est prise ?: " + eating.isOccuped());
						}
					}
				}
			}
			
			logger.info("Client n°" + customer.getId() + " avec ligne : " + lineDistance + " et colonne : " + columnDistance);
			
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
			/**
			 * We check if the customer is still in the process of eating,
			 * if yes, he continue to eat his menu
			 * else he leaves out the restaurant.
			 */
			if(customer.getTimeForEat() > 0) {
				customer.setTimeForEat(customer.getTimeForEat() - 1);
				logger.info("Il mange : " + customer.getTimeForEat());
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
							logger.info("La place " + eating.toString() + "est prise ?: " + eating.isOccuped());
						}
					}
				}
				logger.info("Il a fini de manger : " + customer.getTimeForEat());
			}
		}
	}
}
