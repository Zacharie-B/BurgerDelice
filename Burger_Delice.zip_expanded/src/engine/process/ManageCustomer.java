package engine.process;

import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import config.GameConfiguration;
import engine.map.Block;
import engine.mobile.Customer;
import engine.mobile.Ingredient;
import engine.mobile.Storage;
import gui.MainGUI;
import log.LoggerUtility;

public class ManageCustomer extends MoveCharacters {
	private Logger logger = LoggerUtility.getLogger(ManageCustomer.class, "text");
	private StorageMap storageMapInstance = StorageMap.getInstance();
	
	public ManageCustomer() {

	}

	/**
	 * Do the movement of all customers in the restaurant, if the customer don't get
	 * his order => he goes to oven, next he goes to the order reception and finish 
	 * he goes to the exit .
	 */
	public void movementCustomer() {
		for (Customer customer : MainGUI.manager.getCustomers()) {
			if (customer.isWaitingOrder() == false) {
				moveCustomerBeforeOrder(customer);
			} else if (customer.isWaitingOrder() == true
					&& customer.getPosition().getColumn() == GameConfiguration.COLUMN_ORDER_RECEPTION
					&& customer.getTimeWaiting() < GameConfiguration.TIME_FOR_ORDER_RECEPTION) {
				customer.incrementWaitingTime();
			} else if (customer.getTimeWaiting() == GameConfiguration.TIME_FOR_ORDER_RECEPTION) {
				moveCustomerToTheExit(customer);
			} else {
				moveCustomerToOrder(customer);
			}
		}

	}

	/**
	 * This allow to manage the move of customer, we collisions are avoided.
	 */
	public void moveCustomerBeforeOrder(Customer customer) {
		Block customerBlock = customer.getPosition();
//		logger.info(customerBlock);
		moveTopCollisionFree(customerBlock, MainGUI.manager.getTakenBlocks());

		// Choose the menu randomly.
		if (customer.getPosition().getLine() - GameConfiguration.LINE_ORDER == 0
				&& customer.getPosition().getColumn() == GameConfiguration.COLUMN_ORDER_1
				&& customer.isWaitingOrder() == false) {
			addOrder(customer);
			customer.setWaitingOrder(true);
		}
		
		// Wait his order before the oven.
		if (customer.isWaitingOrder() == true) {
			if (!(customer.getPosition().getColumn() == GameConfiguration.COLUMN_ORDER_1 - 5)) {
				MainGUI.manager.remove(customerBlock);
				//logger.info(customerBlock);
				MainGUI.manager.add(customerBlock);
			}
		}
	}

	/**
	 * The customer move to the reception order point after has done his order.
	 * @param customer
	 */
	private void moveCustomerToOrder(Customer customer) {
		// TODO Auto-generated method stub
		if (customer.getPosition().getColumn() > GameConfiguration.COLUMN_ORDER_RECEPTION) {
			moveLeftCollisionFree(customer.getPosition(), MainGUI.manager.getTakenBlocks());
		}
	}

	/**
	 * The customer who get his order go to the exit.
	 * @param customer
	 */
	private void moveCustomerToTheExit(Customer customer) {
		// TODO Auto-generated method stub
		moveLeftCollisionFree(customer.getPosition(), MainGUI.manager.getTakenBlocks());
		MainGUI.manager.remove(customer.getId());
	}

	/**
	 * Add an order to the customer who is in the case "LINE_ORDER".
	 * @param customer
	 */
	public void addOrder(Customer customer) {
		MainGUI.manager.add(customer.getId(), MainGUI.manager.getMenus().get(customer.getOrder()).getIngredients());
		List<Ingredient> ingredients = MainGUI.manager.getMenus().get(customer.getOrder()).getIngredients();
		for(Ingredient ingredient : ingredients) {
			for(Entry<String, Storage> mapentry : storageMapInstance.ingredientsStorage.entrySet()) {
				if(ingredient.getName().equals(mapentry.getKey())){
					if(ingredient.getNbByMenu() <= mapentry.getValue().getCurrentCapacity()) {
						mapentry.getValue().setCurrentCapacity(mapentry.getValue().getCurrentCapacity() - ingredient.getNbByMenu());
					}
					else {
						mapentry.getValue().setCurrentCapacity(0);
					}
					break;
				}
			}
		}
	}
}
