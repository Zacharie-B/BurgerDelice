package engine.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Checkout;
import engine.mobile.Cook;
import engine.mobile.Counter;
import engine.mobile.Menu;
import engine.mobile.Oven;
import engine.mobile.Storage;

public class RestaurantBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	/**
	 * Initialize all element display at the windows.
	 * 
	 * @param map
	 * @return
	 */
	public static RestaurantManager buildInitElement(Map map) {
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
	private static void initializeMaterial(Map map, RestaurantManager furnitureManager) {
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
	 * @param map
	 * @param furnitureManager
	 */
	private static void createStorage(Map map, RestaurantManager furnitureManager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 2);
		
		List<Storage> storages = new ArrayList<Storage>();
		storages.add(new Storage(block, 100, 0, "Steak"));
		storages.add(new Storage(block, 100, 0, "Pain"));
		storages.add(new Storage(block, 100, 0, "Tomate"));
		storages.add(new Storage(block, 100, 0, "Fromage"));
		storages.add(new Storage(block, 100, 0, "Oignon"));
		storages.add(new Storage(block, 100, 0, "Salade"));

		furnitureManager.setStorages(storages);
	}

	/**
	 * Initialize the oven where there are the meals.
	 * 
	 * @param map
	 * @param furnitureManager
	 */
	private static void createOven(Map map, RestaurantManager furnitureManager) {
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
	private static void createCheckout(Map map, RestaurantManager furnitureManager) {
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
	private static void createCounter(Map map, RestaurantManager furnitureManager) {
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
	private static void createMenu(Map map, RestaurantManager furnitureManager) {
		List<Menu> menus = new ArrayList<Menu>();
		HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
		ingredients.put("Steak", 1);
		ingredients.put("Pain", 2);
		ingredients.put("Salade", 2);
		ingredients.put("Cornichon", 2);
		ingredients.put("Cheddar", 0);
		ingredients.put("Oignon", 0);
		ingredients.put("Tomate", 2);
		Menu menu = new Menu(1, ingredients);
		menus.add(menu);

		ingredients = new HashMap<String, Integer>();
		ingredients.put("Steak", 2);
		ingredients.put("Pain", 3);
		ingredients.put("Salade", 2);
		ingredients.put("Cornichon", 2);
		ingredients.put("Cheddar", 1);
		ingredients.put("Oignon", 1);
		ingredients.put("Tomate", 2);
		menu = new Menu(2, ingredients);
		menus.add(menu);

		ingredients = new HashMap<String, Integer>();
		ingredients.put("Steak", 2);
		ingredients.put("Pain", 2);
		ingredients.put("Salade", 1);
		ingredients.put("Cornichon", 2);
		ingredients.put("Cheddar", 3);
		ingredients.put("Oignon", 0);
		ingredients.put("Tomate", 2);
		menu = new Menu(2, ingredients);
		menus.add(menu);

		furnitureManager.setMenus(menus);
	}
}
