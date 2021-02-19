package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import engine.process.RestaurantManager;

public class ManagementDisplay extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private RestaurantManager manager;
	
	private JTextPane orderDisplay = new JTextPane();
	private JTextPane secondOrderDisplay = new JTextPane();
	private StorageDisplay storageDisplay;
	private MenuDisplay menuDisplay;
	
	/**
	 * Manage the organization on the dashboard, with the restaurant and the storage in the restaurant.
	 * @param manager
	 * @param storageDisplay
	 */
	public ManagementDisplay (RestaurantManager manager, StorageDisplay storageDisplay, MenuDisplay menuDisplay) {
		this.manager = manager;
		this.storageDisplay = storageDisplay;
		this.menuDisplay = menuDisplay;
		
		initStyle();
	}
	
	/**
	 * Initialize the Border Layout and display this.
	 */
	protected void initStyle() {
		GridLayout grid = new GridLayout(3,1);

		setLayout(grid);
		add(orderDisplay);
		add(storageDisplay);
		add(menuDisplay);
		setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		setVisible(true);
	}
	
	/**
	 * Add the orders to HashMap in order to allow the choice for the customer.
	 */
	protected void appendOrders() {
		orderDisplay.setText(null);
		String message = "";
		for (Entry<Integer, HashMap<String, Integer>> mapentry : manager.getOrders().entrySet()) {
			message += manager.toString(mapentry.getKey()) + "\n";
		}
		orderDisplay.setText(message);
	}
	
	

}
