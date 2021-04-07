package process;

import config.GameConfiguration;

public class SimulationUtility {

	public static final int ALL_MONEY_FOR_PAIEMENT = 500;
	
	public static void unitTime() {
		try {
			Thread.sleep(GameConfiguration.GAME_SPEED);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	public static int getRandom(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}

	public static double lookingForPrice(String name) {
		for (int index = 0; index < GameConfiguration.INGREDIENT.length; index++) {
			if(GameConfiguration.INGREDIENT[index].equals(name)) {
				return GameConfiguration.INGREDIENT_PRICES[index] * 3;
			}
		}
		return 0;
	}
}
