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

import data.Ingredient;
import process.RestaurantManager;

/**
 * Manage the display about information on the orders in preparing, the storage
 * and the menus which choose by the customer by random way.
 *
 */
public class ManagementDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private RestaurantManager restaurantManager;

	private JTextPane orderDisplay = new JTextPane();
	private StorageDisplay storageDisplay;
	private MenuDisplay menuDisplay;

	/**
	 * Manage the organization on the dashboard, with the restaurant and the storage
	 * in the restaurant.
	 * 
	 * @param manager
	 * @param storageDisplay
	 */
	public ManagementDisplay(RestaurantManager restaurantManager, StorageDisplay storageDisplay,
			MenuDisplay menuDisplay) {
		this.restaurantManager = restaurantManager;
		this.storageDisplay = storageDisplay;
		this.menuDisplay = menuDisplay;

		initInformationDisplay();
	}

	/**
	 * Initialize the Border Layout and display this with the orders in preparing,
	 * the storage and the menus.
	 */
	protected void initInformationDisplay() {
		GridLayout grid = new GridLayout(3, 1);

		JScrollPane jScrollPaneOrder = new JScrollPane(orderDisplay);
		Dimension preferredSize = new Dimension(300, 500);

		setLayout(grid);

		storageDisplay.setPreferredSize(preferredSize);

		add(jScrollPaneOrder);
		add(menuDisplay);
		add(storageDisplay);

		setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		setVisible(true);
	}

	/**
	 * Display the orders in preparing in window.
	 */
	protected void display() {
		String message = "Argent : ";
		message += (double) Math.round(restaurantManager.getMoney() * 100) / 100 + " euros \n";
		for (Entry<Integer, List<Ingredient>> mapentry : restaurantManager.getOrders().entrySet()) {
			message += restaurantManager.toString(mapentry.getKey()) + "\n";
		}
		orderDisplay.setText(message);
	}

}
