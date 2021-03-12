package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import engine.mobile.Ingredient;
import engine.process.RestaurantManager;

/**
 * Manage the display about information on the orders in preparing, 
 * the storage and the menus which choose by the customer by random way.
 *
 */
public class ManagementDisplay extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private RestaurantManager manager;
	
	private JTextPane orderDisplay = new JTextPane();
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
		
		initInformationDisplay();
	}
	
	/**
	 * Initialize the Border Layout and display this with the orders in preparing, the storage and the menus.
	 */
	protected void initInformationDisplay() {
		GridLayout grid = new GridLayout(3,1);

		setLayout(grid);
		JScrollPane jScrollPaneOrder = new JScrollPane(orderDisplay);
		add(jScrollPaneOrder);
		Dimension preferredSize = new Dimension(300,500);
		storageDisplay.setPreferredSize(preferredSize);
		add(storageDisplay);
		add(menuDisplay);
		setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		setVisible(true);
	}
	
	/**
	 * Display the orders in preparing in window.
	 */
	protected void displayOrders() {
		orderDisplay.setText(null);
		String message = "";
		for(Entry<Integer, List<Ingredient>> mapentry : manager.getOrders().entrySet()) {
			message += manager.toString(mapentry.getKey()) + "\n";
		}
		orderDisplay.setText(message);
	}
	
	

}
