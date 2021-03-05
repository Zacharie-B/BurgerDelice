package gui;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import engine.mobile.Checkout;
import engine.mobile.Cook;
import engine.mobile.Counter;
import engine.mobile.Customer;
import engine.mobile.Oven;
import engine.mobile.Storage;
import engine.process.RestaurantManager;
import engine.process.StorageMap;

/**
 * Here, we paint all graphical elements in the restaurant, there are
 * customers, restaurant material, ovens and cooks.
 *
 */
public class GameDisplay extends JPanel {
	
	private RestaurantManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();
	private StorageMap storageMapInstance = StorageMap.getInstance();

	public GameDisplay(RestaurantManager manager) {
		this.manager = manager;

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(Cook cook : manager.getCooks()) {
			try {
				paintStrategy.paint(cook, g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
		
		for(Oven oven : manager.getOvens()) {
			try {
				paintStrategy.paint(oven, g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for(Customer customer : manager.getCustomers()) {
			try {
				paintStrategy.paint(customer, g);
			} catch (IOException e ) {
				e.printStackTrace();
			}
		}
		
		for(Counter counter : manager.getCounters()) {
			try {
				paintStrategy.paint(counter, g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(Checkout checkout : manager.getCheckouts()) {
			try {
				paintStrategy.paint(checkout, g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			paintStrategy.paint(g);
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
