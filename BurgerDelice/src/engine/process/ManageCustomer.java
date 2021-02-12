package engine.process;

import org.apache.log4j.Logger;

import config.GameConfiguration;
import engine.map.Block;
import engine.mobile.Customer;
import gui.MainGUI;
import log.LoggerUtility;

public class ManageCustomer extends MoveElement {
	private Logger logger = LoggerUtility.getLogger(ManageCustomer.class, "text");

	public ManageCustomer() {

	}

	/**
	 * This allow to manage the move of customer, we collisions are avoided.
	 */
	public void moveCustomerBeforeOrder() {

		for (Customer customer : MainGUI.manager.getCustomers()) {
			Boolean blocked = false;

			for (Block takenBlock : MainGUI.manager.getTakenBlocks()) {
				// If the customer want to go at top.
				if (customer.getPosition().getLine() - 1 == takenBlock.getLine()
						&& customer.getPosition().getColumn() == takenBlock.getColumn()) {
					blocked = true;
				}
				// If the customer wants to go at left.
				if (customer.getPosition().getLine() == takenBlock.getLine()
						&& customer.getPosition().getColumn() - 1 == takenBlock.getColumn()) {
					blocked = true;
				}
				/*
				 * if(customer.getPosition().getLine() == takenBlock.getLine() &&
				 * customer.getPosition().getColumn() + 1 == takenBlock.getColumn()) { blocked =
				 * true; } if(customer.getPosition().getLine() + 1 == takenBlock.getLine() &&
				 * customer.getPosition().getColumn() == takenBlock.getColumn()) { blocked =
				 * true; }
				 */
			}

			// Allows to move the customer at top if there nothing which block.
			if (blocked == false && customer.isWaitingOrder() == false) {
				Block customerBlock = customer.getPosition();
				MainGUI.manager.remove(customerBlock);
				logger.info(customerBlock);
				moveTop(customerBlock);
				MainGUI.manager.add(customerBlock);
			}

			// Choose the menu 
			if (customer.getPosition().getLine() - GameConfiguration.LINE_ORDER == 0
					&& customer.getPosition().getColumn() == GameConfiguration.COLUMN_ORDER
					&& customer.isWaitingOrder() == false) {
				customer.setOrder(randomNumber(customer));
				customer.setWaitingOrder(true);
			}

			if (blocked == false && customer.isWaitingOrder() == true) {
				if (!(customer.getPosition().getColumn() == GameConfiguration.COLUMN_ORDER - 5)) {
					Block customerBlock = customer.getPosition();
					MainGUI.manager.remove(customerBlock);
					logger.info(customerBlock);
					moveLeft(customerBlock);
					MainGUI.manager.add(customerBlock);
				}
			}
		}

	}

	public int randomNumber(Customer customer) {
		int randomNumber = (int) (Math.random() * 3);
		MainGUI.manager.add(customer.getName(), MainGUI.manager.getMenus().get(randomNumber).getIngredients());
		return randomNumber;
	}
}
