package gui;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import data.Checkout;
import data.Cook;
import data.Counter;
import data.Customer;
import data.Oven;
import data.Server;
import data.Storage;
import data.StorageMap;
import data.TableForEating;
import process.RestaurantManager;

/**
 * Here, we paint all graphical elements in the restaurant, there are customers,
 * restaurant material, ovens and cooks.
 * 
 */
public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private RestaurantManager restaurantManager;
	private PaintStrategy paintStrategy = new PaintStrategy();
	private StorageMap storageMapInstance = StorageMap.getInstance();

	public GameDisplay(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Cook cook : restaurantManager.getCooks()) {
			try {
				paintStrategy.paint(cook, g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (Server server : restaurantManager.getServers()) {
			try {
				paintStrategy.paint(server, g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Storage storage = storageMapInstance.getIngredientToStorage("Frites moyenne");

		try {
			paintStrategy.paint(storage, g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Oven oven : restaurantManager.getOvens()) {
			try {
				paintStrategy.paint(oven, g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (Customer customer : restaurantManager.getCustomers()) {
			try {
				paintStrategy.paint(customer, g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (Counter counter : restaurantManager.getCounters()) {
			try {
				paintStrategy.paint(counter, g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (Checkout checkout : restaurantManager.getCheckouts()) {
			try {
				paintStrategy.paint(checkout, g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(TableForEating tableForEating : restaurantManager.getTableForEatings()) {
			try {
				paintStrategy.paint(tableForEating, g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			paintStrategy.paint(g);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
