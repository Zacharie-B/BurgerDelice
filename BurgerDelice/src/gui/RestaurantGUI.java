package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import config.GameConfiguration;
import data.RestaurantMap;
import process.CustomerManager;
import process.PayOfEmployee;
import process.Payment;
import process.RestaurantBuilder;
import process.RestaurantManager;
import process.SimulationUtility;

public class RestaurantGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private RestaurantMap restaurantMap;
	private RestaurantManager restaurantManager;
	private CustomerManager customerManager;
	private Payment payOfEmployee;

	private RestaurantBuilder restaurantBuilder;

	private GameDisplay gameDisplay;
	private ManagementDisplay managementDisplay;
	private StorageManagementDisplay storageManagementDisplay;
	private MenuDisplay menuDisplay;

	private boolean status = false;

	public RestaurantGUI(String title) {
		super(title);

		init();
	}

	/**
	 * Initialize all elements in the restaurant, allowing to manage of all
	 * features.
	 */
	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		restaurantBuilder = new RestaurantBuilder();

		restaurantMap = restaurantBuilder.buildMap();
		restaurantManager = restaurantBuilder.buildElements(restaurantMap);

		customerManager = new CustomerManager(restaurantManager);

		gameDisplay = new GameDisplay(restaurantManager);
		gameDisplay.setPreferredSize(preferredSize);

		storageManagementDisplay = new StorageManagementDisplay(restaurantManager);
		menuDisplay = new MenuDisplay(restaurantManager);

		managementDisplay = new ManagementDisplay(restaurantManager, storageManagementDisplay, menuDisplay);
		managementDisplay.setPreferredSize(preferredSize);

		payOfEmployee = new PayOfEmployee(restaurantManager, 100);

		contentPane.add(gameDisplay, BorderLayout.WEST);
		contentPane.add(managementDisplay, BorderLayout.EAST);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();

		setVisible(true);
		setPreferredSize(new Dimension(GameConfiguration.WINDOW_WIDTH * 2, GameConfiguration.WINDOW_HEIGHT * 2));

	}

	/**
	 * Call the different features of our restaurant.
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!status) {
			SimulationUtility.unitTime();
			restaurantManager.generateCustomer();
			restaurantManager.incrementTimeOrder();

			customerManager.moveCustomer();
			managementDisplay.moneyDisplay();

			storageManagementDisplay.getStorageDisplay().updateStorageDisplay();
			storageManagementDisplay.getOrderDisplay().updateTime();
			
			payOfEmployee.managePayment();
			
			gameDisplay.repaint();

		}
	}

}
