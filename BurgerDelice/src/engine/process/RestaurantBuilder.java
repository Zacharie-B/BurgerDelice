package engine.process;

import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.RestaurantMap;
import engine.mobile.Checkout;
import engine.mobile.Cook;
import engine.mobile.Counter;
import engine.mobile.Ingredient;
import engine.mobile.Menu;
import engine.mobile.Oven;
import engine.mobile.Storage;

public class RestaurantBuilder {

	private static StorageMap storageMapInstance = StorageMap.getInstance();
	
	public static RestaurantMap buildMap() {
		return new RestaurantMap(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	/**
	 * Initialize all element display at the windows.
	 * 
	 * @param map
	 * @return
	 */
	public static RestaurantManager buildInitElement(RestaurantMap map) {
		RestaurantManager elementManager = new RestaurantManager(map);

		initializeMaterial(map, elementManager);
		initializeCharacters(elementManager);

		return elementManager;
	}

	/**
	 * Initialize the map with all material in order to prepared and to give the
	 * order.
	 * 
	 * @param map
	 * @param furnitureManager
	 */
	private static void initializeMaterial(RestaurantMap map, RestaurantManager furnitureManager) {
		createStorage(map, furnitureManager);
		createOven(map, furnitureManager);
		createCheckout(map, furnitureManager);
		createCounter(map, furnitureManager);
		createMenu(map, furnitureManager);
	}

	/**
	 * Initialize the characters who move in the map, there are cooks and customers.
	 * 
	 * @param characterManager
	 */
	private static void initializeCharacters(RestaurantManager characterManager) {

		List<Cook> cooks = new ArrayList<Cook>();
		List<Block> takenBlocks = new ArrayList<Block>();

		Block blockCook = new Block(GameConfiguration.LINE_COUNT - 10, GameConfiguration.COLUMN_COUNT - 2);

		cooks.add(new Cook(blockCook, "Philippe", 1000, 4));

		characterManager.setCooks(cooks);
		characterManager.setTakenBlock(takenBlocks);

	}

	/**
	 * Initialize the storage in the restaurant before that customers are arriving.
	 * 
	 * @param restaurantMap
	 * @param furnitureManager
	 */
	private static void createStorage(RestaurantMap restaurantMap, RestaurantManager furnitureManager) {
		Block block = restaurantMap.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 2);
		
		storageMapInstance.addIngredientInStorage("Steak", new Storage(block, 100, 80, "Steak"));
		storageMapInstance.addIngredientInStorage("Pain", new Storage(block, 100, 80, "Pain"));
		storageMapInstance.addIngredientInStorage("Tomate", new Storage(block, 100, 50, "Tomate"));
		storageMapInstance.addIngredientInStorage("Cheddar", new Storage(block, 100, 100, "Cheddar"));
		storageMapInstance.addIngredientInStorage("Cornichon", new Storage(block, 100, 100, "Cornichon"));
		storageMapInstance.addIngredientInStorage("Oignon", new Storage(block, 100, 50, "Oignon"));
		storageMapInstance.addIngredientInStorage("Salade", new Storage(block, 100, 60, "Salade"));
		storageMapInstance.addIngredientInStorage("Poulet pané", new Storage(block, 100, 90, "Poulet pané"));
		storageMapInstance.addIngredientInStorage("Fish", new Storage(block, 100, 50, "Fish"));
		storageMapInstance.addIngredientInStorage("Frites moyenne", new Storage(block, 100, 100, "Frites moyenne"));
		storageMapInstance.addIngredientInStorage("Sauce", new Storage(block, 100, 80, "Sauce"));
	}

	/**
	 * Initialize the oven where there are the meals.
	 * 
	 * @param map
	 * @param furnitureManager
	 */
	private static void createOven(RestaurantMap map, RestaurantManager furnitureManager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 3);
		List<Oven> ovens = new ArrayList<Oven>();
		ovens.add(new Oven(block, 3, 4));

		block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 4);
		ovens.add(new Oven(block, 3, 4));

		furnitureManager.setOvens(ovens);
	}

	/**
	 * Initialize the checkout which storage the money after the orders.
	 * 
	 * @param map
	 * @param furnitureManager
	 */
	private static void createCheckout(RestaurantMap map, RestaurantManager furnitureManager) {
		List<Checkout> checkouts = new ArrayList<Checkout>();
		checkouts.add(new Checkout(new Block(GameConfiguration.LINE_COUNT - 8, GameConfiguration.COLUMN_COUNT - 2),
				10000, 0));
		checkouts.add(new Checkout(new Block(GameConfiguration.LINE_COUNT - 8, GameConfiguration.COLUMN_COUNT - 5),
				10000, 0));
		checkouts.add(new Checkout(new Block(GameConfiguration.LINE_COUNT - 8, GameConfiguration.COLUMN_COUNT - 8),
				10000, 0));
		furnitureManager.setCheckouts(checkouts);
	}

	/**
	 * Initialize the counter who gives the order to customers.
	 * 
	 * @param map
	 * @param furnitureManager
	 */
	private static void createCounter(RestaurantMap map, RestaurantManager furnitureManager) {
		List<Counter> counters = new ArrayList<Counter>();

		for (int index = 0; index < GameConfiguration.COLUMN_COUNT; index++) {
			Block block = map.getBlock(GameConfiguration.COLUMN_COUNT - 8, index);
			counters.add(new Counter(block));
		}

		furnitureManager.setCounters(counters);

	}

	/**
	 * Initialize menus for the choice of customers.
	 * 
	 * @param map
	 * @param furnitureManager
	 */
	private static void createMenu(RestaurantMap map, RestaurantManager furnitureManager) {
		List<Menu> menus = new ArrayList<Menu>();
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(new Ingredient("Steak", 2));
		ingredients.add(new Ingredient("Pain", 2));
		ingredients.add(new Ingredient("Salade", 2));
		ingredients.add(new Ingredient("Cornichon", 2));
		ingredients.add(new Ingredient("Cheddar", 1));
		ingredients.add(new Ingredient("Oignon", 0));
		ingredients.add(new Ingredient("Tomate", 2));
		ingredients.add(new Ingredient("Frites moyenne", 2));
		ingredients.add(new Ingredient("Sauce", 1));
		
		Menu menu = new Menu(0, ingredients);
		menus.add(menu);
		
		List<Ingredient> ingredients1 = new ArrayList<Ingredient>();
		ingredients1.add(new Ingredient("Poulet pané", 2));
		ingredients1.add(new Ingredient("Pain", 3));
		ingredients1.add(new Ingredient("Salade", 2));
		ingredients1.add(new Ingredient("Cornichon", 2));
		ingredients1.add(new Ingredient("Cheddar", 1));
		ingredients1.add(new Ingredient("Oignon", 1));
		ingredients1.add(new Ingredient("Tomate", 2));
		ingredients1.add(new Ingredient("Frites moyenne", 1));
		ingredients1.add(new Ingredient("Sauce", 1));
		
		menu = new Menu(1, ingredients1);
		menus.add(menu);

		List<Ingredient> ingredients2 = new ArrayList<Ingredient>();
		ingredients2.add(new Ingredient("Fish", 2));
		ingredients2.add(new Ingredient("Pain", 2));
		ingredients2.add(new Ingredient("Salade", 1));
		ingredients2.add(new Ingredient("Cornichon", 2));
		ingredients2.add(new Ingredient("Cheddar", 3));
		ingredients2.add(new Ingredient("Oignon", 0));
		ingredients2.add(new Ingredient("Tomate", 2));
		ingredients2.add(new Ingredient("Frites moyenne", 2));
		ingredients2.add(new Ingredient("Sauce", 1));
		
		menu = new Menu(2, ingredients2);
		menus.add(menu);

		furnitureManager.setMenus(menus);
	}
}
