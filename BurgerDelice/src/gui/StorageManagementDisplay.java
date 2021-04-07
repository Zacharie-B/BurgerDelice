package gui;

import java.awt.Color;

import javax.swing.JPanel;

import process.RestaurantManager;

public class StorageManagementDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private BuyDisplay buyDisplay;
	private StorageDisplay storageDisplay;

	public StorageManagementDisplay(RestaurantManager restaurantManager) {

		buyDisplay = new BuyDisplay(restaurantManager);
		storageDisplay = new StorageDisplay(restaurantManager, buyDisplay);

		init();
	}

	private void init() {
		setBackground(Color.WHITE);
		
		add(storageDisplay);
		add(buyDisplay);
	}

	public BuyDisplay getBuyDisplay() {
		return buyDisplay;
	}

	public StorageDisplay getStorageDisplay() {
		return storageDisplay;
	}

}
