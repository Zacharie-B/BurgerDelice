package engine.process;

import org.apache.log4j.Logger;

import config.GameConfiguration;
import engine.map.Block;
import engine.mobile.Customer;
import gui.MainGUI;
import log.LoggerUtility;

public class ManageCustomer extends MoveElement{
	private Logger logger = LoggerUtility.getLogger(ManageCustomer.class, "text");

	public ManageCustomer() {
		
	}
	
	public void moveCustomerBeforeOrder() {
		
		for(Customer customer : MainGUI.manager.getCustomers()) {
			Boolean blocked = false;
			for (Block takenBlock : MainGUI.manager.getTakenBlocks()) {
				if (customer.getPosition().getLine() - 1 == takenBlock.getLine() && 
						customer.getPosition().getColumn() == takenBlock.getColumn()) {
					blocked = true;
				}
			}
				
			if (blocked == false && customer.isWaitingOrder() == false) {
				Block customerBlock = customer.getPosition();
				MainGUI.manager.remove(customerBlock);
				logger.info(customerBlock);
				moveTop(customerBlock);
				MainGUI.manager.add(customerBlock);
			}
				
			if(customer.getPosition().getLine() - GameConfiguration.LINE_ORDER == 0 && customer.getPosition().getColumn() == GameConfiguration.COLUMN_ORDER
					&& customer.isWaitingOrder() == false) {
				customer.setOrder(randomNumber(customer));
				customer.setWaitingOrder(true);
			}
				
			if(blocked == false && customer.isWaitingOrder() == true) {
				Block customerBlock = customer.getPosition();
				MainGUI.manager.remove(customerBlock);
				logger.info(customerBlock);
				moveLeft(customerBlock);
				MainGUI.manager.add(customerBlock);
			}
		}	
	}
	
	public int randomNumber(Customer customer) {
		int randomNumber = (int)(Math.random() * 3);
		MainGUI.manager.add(customer.getName(), MainGUI.manager.getMenus().get(randomNumber).getIngredients());
		return randomNumber;
	}
}
