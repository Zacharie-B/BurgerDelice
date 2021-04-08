package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import process.RestaurantManager;

public class StorageManagementDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private BuyDisplay buyDisplay;
	private StorageDisplay storageDisplay;
	private OrderDisplay orderDisplay;

	private JLabel storageLabel = new JLabel("Stockage du restaurant");

	private JLabel orderLabel = new JLabel("Deliver'food");

	public StorageManagementDisplay(RestaurantManager restaurantManager) {

		orderDisplay = new OrderDisplay(restaurantManager);
		buyDisplay = new BuyDisplay(restaurantManager, orderDisplay);
		storageDisplay = new StorageDisplay(restaurantManager, buyDisplay);

		init();
	}

	private void init() {
		setBackground(Color.WHITE);
		
		storageLabel.setPreferredSize(new Dimension(500, 20));
		storageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		storageLabel.setBackground(new Color(32, 207, 190));
		storageLabel.setForeground(Color.WHITE);
		storageLabel.setOpaque(true);

		orderLabel.setPreferredSize(new Dimension(500, 20));
		orderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderLabel.setBackground(new Color(32, 207, 190));
		orderLabel.setForeground(Color.WHITE);
		orderLabel.setOpaque(true);
		
		add(storageLabel);
		add(storageDisplay);
		add(orderLabel);
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
