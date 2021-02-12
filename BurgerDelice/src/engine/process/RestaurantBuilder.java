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
import engine.mobile.Customer;
import engine.mobile.Menu;
import engine.mobile.Oven;
import engine.mobile.Storage;

public class RestaurantBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static RestaurantManager buildInitElement(Map map) {
		RestaurantManager elementManager = new RestaurantManager(map);

		initializeMaterial(map, elementManager);
		initializeCharacters(elementManager);

		return elementManager;
	}

	private static void initializeMaterial(Map map, RestaurantManager furnitureManager) {
		createStorage(map, furnitureManager);
		createOven(map, furnitureManager);
		createCheckout(map, furnitureManager);
		createCounter(map, furnitureManager);
		createMenu(map, furnitureManager);
	}

	private static void initializeCharacters(RestaurantManager characterManager) {

		List<Cook> cooks = new ArrayList<Cook>();
		List<Customer> customers = new ArrayList<Customer>();
		List<Block> takenBlocks = new ArrayList<Block>();

		Block blockCustomer = new Block(GameConfiguration.LINE_ENTRY, GameConfiguration.COLUMN_ENTRY);
		Block blockCustomer2 = new Block(GameConfiguration.LINE_ENTRY - 1, GameConfiguration.COLUMN_ENTRY);
		Block blockCustomer3 = new Block(GameConfiguration.LINE_ENTRY - 2, GameConfiguration.COLUMN_ENTRY);

		Block blockCook = new Block(GameConfiguration.LINE_COUNT - 10, GameConfiguration.COLUMN_COUNT - 2);

		customers.add(new Customer(blockCustomer, "Rebecca", 1, false));
		customers.add(new Customer(blockCustomer2, "Jean", 1, false));
		customers.add(new Customer(blockCustomer3, "Louis", 3, false));

		takenBlocks.add(blockCustomer);
		takenBlocks.add(blockCustomer2);
		takenBlocks.add(blockCustomer3);

		cooks.add(new Cook(blockCook, "Philippe", 1000, 4));

		characterManager.setCustomers(customers);
		characterManager.setCooks(cooks);
		characterManager.setTakenBlock(takenBlocks);

	}

	private static void createStorage(Map map, RestaurantManager furnitureManager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 1);
		List<Storage> storages = new ArrayList<Storage>();
		storages.add(new Storage(block, 100, 0, "Steak"));

		block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 2);
		storages.add(new Storage(block, 100, 0, "Pain"));

		furnitureManager.setStorages(storages);
	}

	private static void createOven(Map map, RestaurantManager furnitureManager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 3);
		List<Oven> ovens = new ArrayList<Oven>();
		ovens.add(new Oven(block, 30, 4));

		block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 4);
		ovens.add(new Oven(block, 30, 4));

		furnitureManager.setOvens(ovens);
	}

	private static void createCheckout(Map map, RestaurantManager furnitureManager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 9, GameConfiguration.COLUMN_COUNT - 2);
		List<Checkout> checkouts = new ArrayList<Checkout>();
		checkouts.add(new Checkout(block, 1000, 0));

		furnitureManager.setCheckouts(checkouts);

	}

	private static void createCounter(Map map, RestaurantManager furnitureManager) {
		List<Counter> counters = new ArrayList<Counter>();

		for (int index = 0; index < GameConfiguration.COLUMN_COUNT; index++) {
			if (index != GameConfiguration.COLUMN_COUNT - 2) {
				Block block = map.getBlock(GameConfiguration.COLUMN_COUNT - 9, index);
				counters.add(new Counter(block));
			}
		}

		furnitureManager.setCounters(counters);

	}
	
	private static void createMenu(Map map, RestaurantManager furnitureManager) {
		List<Menu> menus = new ArrayList<Menu>();
		HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
		ingredients.put("Steak", 1);
		ingredients.put("Pain", 2);
		Menu menu = new Menu(1, ingredients);
		menus.add(menu);

		ingredients = new HashMap<String, Integer>();
		ingredients.put("Steak", 1);
		ingredients.put("Pain", 2);
		ingredients.put("Cheddar", 2);
		menu = new Menu(2, ingredients);
		menus.add(menu);

		ingredients = new HashMap<String, Integer>();
		ingredients.put("Steak", 2);
		ingredients.put("Pain", 3);
		ingredients.put("Cheddar", 2);
		ingredients.put("Oignon", 2);
		menu = new Menu(2, ingredients);
		menus.add(menu);

		furnitureManager.setMenus(menus);
	}
}
