package test;

import gui.RestaurantGUI;

public class TestGame {
	public static void main(String[] args) {

		RestaurantGUI gameMainGUI = new RestaurantGUI("Burger Delice");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}
}