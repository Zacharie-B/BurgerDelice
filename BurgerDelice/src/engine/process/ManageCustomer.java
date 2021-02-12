package engine.process;

import org.apache.log4j.Logger;

import config.GameConfiguration;
import engine.map.Block;
import engine.mobile.Customer;
import gui.MainGUI;
import log.LoggerUtility;

public class ManageCustomer extends MoveCharacters {
	private Logger logger = LoggerUtility.getLogger(ManageCustomer.class, "text");

	public ManageCustomer() {

	}

	/**
	 * Do the movement of all customers in the restaurant.
	 */
	public void movementCustomer() {
		for(Customer customer : MainGUI.manager.getCustomers()) {
			if(customer.isWaitingOrder() == false) {
				moveCustomerBeforeOrder(customer);
			}
			else {
				moveCustomerToTHeExit(customer);
			}
		}
	}
	
	/**
	 * This allow to manage the move of customer, we collisions are avoided.
	 */
	public void moveCustomerBeforeOrder(Customer customer) {
			Block customerBlock = customer.getPosition();
			logger.info(customerBlock);
			moveTopCollisionFree(customerBlock, MainGUI.manager.getTakenBlocks());

		// Choose the menu randomly.
		if (customer.getPosition().getLine() - GameConfiguration.LINE_ORDER == 0
				&& customer.getPosition().getColumn() == GameConfiguration.COLUMN_ORDER_1
				&& customer.isWaitingOrder() == false) {
			customer.setOrder(randomNumber(customer));
			customer.setWaitingOrder(true);
		}
		// 
		if (customer.isWaitingOrder() == true) {
			if (!(customer.getPosition().getColumn() == GameConfiguration.COLUMN_ORDER_1 - 5)) {
				MainGUI.manager.remove(customerBlock);
				logger.info(customerBlock);
				moveLeft(customerBlock);
				MainGUI.manager.add(customerBlock);
			}
		}
	}

	private void moveCustomerToTHeExit(Customer customer) {
		// TODO Auto-generated method stub
		moveLeftCollisionFree(customer.getPosition(), MainGUI.manager.getTakenBlocks());
	}
	
	public int randomNumber(Customer customer) {
		int randomNumber = (int) (Math.random() * 3);
		MainGUI.manager.add(customer.getName(), MainGUI.manager.getMenus().get(randomNumber).getIngredients());
		return randomNumber;
	}
}
