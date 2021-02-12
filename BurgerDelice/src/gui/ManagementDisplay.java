package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import engine.process.RestaurantManager;

public class ManagementDisplay extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private RestaurantManager manager;
	
	private JTextPane orderDisplay = new JTextPane();
	private StorageDisplay storageDisplay;
	
	/**
	 * Manage the organization on the dashboard, with the restaurant and the storage in the restaurant.
	 * @param manager
	 * @param storageDisplay
	 */
	public ManagementDisplay (RestaurantManager manager, StorageDisplay storageDisplay) {
		this.manager = manager;
		this.storageDisplay = storageDisplay;
		
		initStyle();
	}
	
	/**
	 * Initialize the Border Layout and display this.
	 */
	protected void initStyle() {
		setLayout(new BorderLayout());
		add(orderDisplay, BorderLayout.NORTH);
		add(storageDisplay, BorderLayout.SOUTH);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	
	/**
	 * Add the orders to HashMap in order to allow the choice for the customer.
	 */
	protected void appendOrders() {
		orderDisplay.setText(null);
		String message = "";
		for (Entry<String, HashMap<String, Integer>> mapentry : manager.getOrders().entrySet()) {
			message += manager.toString(mapentry.getKey())+ " \n";
		}
		orderDisplay.setText(message);
	}
	
	

}
