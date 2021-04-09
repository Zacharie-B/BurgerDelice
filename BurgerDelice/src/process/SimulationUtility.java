package process;

import config.GameConfiguration;

/**
 * 
 * This utility class contains util functions used by the simulation.
 */
public class SimulationUtility {

	public static final int ALL_MONEY_FOR_PAIEMENT = 500;

	/**
	 * Simulates the unit time defined for the simulation.
	 */
	public static void unitTime() {
		try {
			Thread.sleep(GameConfiguration.GAME_SPEED);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Generates a random number between two numbers.
	 */
	public static int getRandom(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}

	/**
	 * Search a price for ingredient
	 */
	public static double lookingForPrice(String name) {
		for (int index = 0; index < GameConfiguration.INGREDIENT.length; index++) {
			if (GameConfiguration.INGREDIENT[index].equals(name)) {
				return GameConfiguration.INGREDIENT_PRICES[index] * 3;
			}
		}
		return 0;
	}
	
	public static double lookingIngredientToBuy(String name) {
		for (int index = 0; index < GameConfiguration.INGREDIENT.length; index++) {
			if (GameConfiguration.INGREDIENT[index].equals(name)) {
				return GameConfiguration.INGREDIENT_PRICES[index];
			}
		}
		return 0;
	}
}
