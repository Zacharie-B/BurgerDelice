package gui;

import java.awt.Color;

import javax.swing.JPanel;

import process.RestaurantManager;

public class StorageManagementDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private BuyDisplay buyDisplay;
	private StorageDisplay storageDisplay;
	private OrderDisplay orderDisplay;

	public StorageManagementDisplay(RestaurantManager restaurantManager) {

		orderDisplay = new OrderDisplay(restaurantManager);
		buyDisplay = new BuyDisplay(restaurantManager, orderDisplay);
		storageDisplay = new StorageDisplay(restaurantManager, buyDisplay);

		init();
	}

	private void init() {
		setBackground(Color.WHITE);

		add(storageDisplay);
		add(buyDisplay);
		add(orderDisplay);
	}

	public BuyDisplay getBuyDisplay() {
		return buyDisplay;
	}

	public StorageDisplay getStorageDisplay() {
		return storageDisplay;
	}

	public OrderDisplay getOrderDisplay() {
		return orderDisplay;
	}

}
