package process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import config.GameConfiguration;
import data.Block;
import data.Customer;
import data.Ingredient;
import data.Storage;
import data.StorageMap;
import log.LoggerUtility;

public class CustomerManager extends MoveCharacters {

	private StorageMap storageMapInstance = StorageMap.getInstance();

	private RestaurantManager restaurantManager;
	private MoveToEatOnTheRestaurant moveToEatOnTheRestaurant = new MoveToEatOnTheRestaurant();
	private Logger log = LoggerUtility.getLogger(CustomerManager.class, "process");
	
	public CustomerManager(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
	}

	/**
	 * Choose the movement of all customers in function if he go order, take order, etc.
	 */
	public void moveCustomer() {
		List<Customer> customers = restaurantManager.getCustomers();
		for (Customer customer : customers) {
			if (!customer.isWaitingOrder()) {
				moveCustomerBeforeOrder(customer);
			}
			else if(!customer.isHappiness()) {
				moveCustomerToExit(customer);
			}
			else if (customer.isWaitingOrder()
					&& customer.getPosition().getX() == GameConfiguration.COLUMN_ORDER_RECEPTION
					&& customer.getTimeWaiting() < GameConfiguration.TIME_FOR_ORDER_RECEPTION) {
				customer.incrementWaitingTime();
			}
			else if (customer.getTimeWaiting() == GameConfiguration.TIME_FOR_ORDER_RECEPTION) {
				if(customer.isOnTheRestaurant()) {
					moveToFindTable(customer);
				}
				else{
					moveCustomerToExit(customer);
				}
			} else {
				moveCustomerToOrder(customer);
			}
		}
	}

	/**
	 * Move one customer until first server to order.
	 * @param customer who move to order
	 */
	private void moveCustomerBeforeOrder(Customer customer) {
		Block block = customer.getPosition();

		moveTopCollision(block, restaurantManager);

		if (customer.getPosition().getY() - GameConfiguration.LINE_ORDER == 0 && customer.isWaitingOrder() == false) {
			addOrder(customer);

			customer.setWaitingOrder(true);
		}
	}

	/**
	 * Move one customer until second server to get his order.
	 * @param customer who move to get his order
	 */
	private void moveCustomerToOrder(Customer customer) {
		if (customer.getPosition().getX() > GameConfiguration.COLUMN_ORDER_RECEPTION) {
			moveLeftCollision(customer.getPosition(), restaurantManager);
		}
	}

	/**
	 * Move one customer until the exit.
	 * @param customer
	 */
	private void moveCustomerToExit(Customer customer) {
		int error = moveLeftCollision(customer.getPosition(), restaurantManager);
		if(error == 1)
			error = moveDownCollision(customer.getPosition(), restaurantManager);
			if(error == 1)
				moveRightCollision(customer.getPosition(), restaurantManager);

		restaurantManager.removeOrder(customer.getId());
	}

	/**
	 * Add an order for a customer if there are enough ingredients, do nothing else.
	 * @param customer who ordering
	 */
	private void addOrder(Customer customer) {
		List<Ingredient> ingredients = restaurantManager.getMenus().get(customer.getOrder()).getIngredients();
		List<Ingredient> ingredientsForOrder = new ArrayList<Ingredient>();
		
		Map<String, Storage> storages = storageMapInstance.getIngredientsStorage();
		
		boolean enoughIngredient = true;
		for (Ingredient ingredient : ingredients) {
			if(storages.get(ingredient.getName()).getCurrentCapacity() >= ingredient.getNbByMenu()) {
				ingredientsForOrder.add(ingredient);
			}
			else {
				enoughIngredient = false;
				customer.setHappiness(false);
			}
		}
		if(enoughIngredient) {
			for(Ingredient ingredientOrder : ingredientsForOrder) {
				storages.get(ingredientOrder.getName()).decrementCapacity(ingredientOrder.getNbByMenu());;
				restaurantManager.addMoney(SimulationUtility.lookingForPrice(ingredientOrder.getName()) * ingredientOrder.getNbByMenu());
			}
			restaurantManager.add(customer.getId(), restaurantManager.getMenus().get(customer.getOrder()).getIngredients());
		}
	}
	
	/**
	 * Move the customer until he find a table to eat on the restaurant.
	 * @param customer who eat on the restaurant
	 */
	private void moveToFindTable(Customer customer) {
		moveToEatOnTheRestaurant.eatOnTable(customer, restaurantManager);

		restaurantManager.removeOrder(customer.getId());
	}
	
	
}
