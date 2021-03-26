package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import config.GameConfiguration;
import data.RestaurantMap;
import process.CustomerManager;
import process.RestaurantBuilder;
import process.RestaurantManager;
import process.SimulationUtility;

public class RestaurantGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private RestaurantMap restaurantMap;
	private RestaurantManager restaurantManager;
	private CustomerManager customerManager;

	private RestaurantBuilder restaurantBuilder;

	private GameDisplay gameDisplay;
	private ManagementDisplay managementDisplay;
	private StorageDisplay storageDisplay;
	private MenuDisplay menuDisplay;

	private boolean status = false;

	public RestaurantGUI(String title) {
		super(title);

		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		restaurantBuilder = new RestaurantBuilder();

		restaurantMap = restaurantBuilder.buildMap();
		restaurantManager = restaurantBuilder.buildElements(restaurantMap);

		customerManager = new CustomerManager(restaurantManager);

		gameDisplay = new GameDisplay(restaurantManager);
		gameDisplay.setPreferredSize(preferredSize);

		storageDisplay = new StorageDisplay();
		menuDisplay = new MenuDisplay(restaurantManager);

		managementDisplay = new ManagementDisplay(restaurantManager, storageDisplay, menuDisplay);
		managementDisplay.setPreferredSize(preferredSize);

		contentPane.add(gameDisplay, BorderLayout.WEST);
		contentPane.add(managementDisplay, BorderLayout.EAST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();

		setVisible(true);
		setPreferredSize(new Dimension(GameConfiguration.WINDOW_WIDTH * 2, GameConfiguration.WINDOW_HEIGHT * 2));

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!status) {

			SimulationUtility.unitTime();

			restaurantManager.generateCustomer();
			
			gameDisplay.repaint();
			customerManager.moveCustomer();
			managementDisplay.display();
			storageDisplay.updateStorageDisplay();

		}
	}

}
