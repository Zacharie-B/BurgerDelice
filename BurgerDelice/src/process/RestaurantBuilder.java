package process;

import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import data.Block;
import data.Checkout;
import data.Cook;
import data.Counter;
import data.Ingredient;
import data.Menu;
import data.Oven;
import data.PositionForEating;
import data.RestaurantMap;
import data.Storage;
import data.StorageMap;
import data.TableForEating;

public class RestaurantBuilder {

	private StorageMap storageMapInstance = StorageMap.getInstance();

	public RestaurantMap buildMap() {
		return new RestaurantMap(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public RestaurantManager buildElements(RestaurantMap restaurantMap) {
		RestaurantManager restaurantManager = new RestaurantManager();

		initCharacters(restaurantManager);
		createStorages(restaurantMap);
		createOvens(restaurantManager);
		createCheckouts(restaurantManager);
		createCounters(restaurantManager);
		initTableForEating(restaurantMap, restaurantManager);
		createMenu(restaurantManager);

		return restaurantManager;
	}

	private void initTableForEating(RestaurantMap restaurantMap, RestaurantManager restaurantManager) {
		TableForEating tableForEating1 = new TableForEating(new
				Block(GameConfiguration.LINE_COUNT - 9, GameConfiguration.COLUMN_COUNT - 5),
				new PositionForEating(GameConfiguration.LINE_COUNT - 8, GameConfiguration.COLUMN_COUNT - 5),
				new PositionForEating(GameConfiguration.LINE_COUNT - 10, GameConfiguration.COLUMN_COUNT - 5));
		restaurantManager.addTable(tableForEating1);
		restaurantManager.addTakenBlock(tableForEating1.getPosition());
		
		TableForEating tableForEating2 = new TableForEating(new 
				Block(GameConfiguration.LINE_COUNT - 5, GameConfiguration.COLUMN_COUNT - 5), 
				new PositionForEating(GameConfiguration.LINE_COUNT - 4, GameConfiguration.COLUMN_COUNT - 5),
				new PositionForEating(GameConfiguration.LINE_COUNT - 6, GameConfiguration.COLUMN_COUNT - 5));
		restaurantManager.addTable(tableForEating2);
		restaurantManager.addTakenBlock(tableForEating2.getPosition());
		
		TableForEating tableForEating3 = new TableForEating(new 
				Block(GameConfiguration.LINE_COUNT - 5, GameConfiguration.COLUMN_COUNT - 4),
				new PositionForEating(GameConfiguration.LINE_COUNT - 4, GameConfiguration.COLUMN_COUNT - 4),
				new PositionForEating(GameConfiguration.LINE_COUNT - 6, GameConfiguration.COLUMN_COUNT - 4));
		restaurantManager.addTable(tableForEating3);
		restaurantManager.addTakenBlock(tableForEating3.getPosition());
		
		TableForEating tableForEating4 = new TableForEating(new 
				Block(GameConfiguration.LINE_COUNT - 9, GameConfiguration.COLUMN_COUNT - 4),
				new PositionForEating(GameConfiguration.LINE_COUNT - 8, GameConfiguration.COLUMN_COUNT - 4),
				new PositionForEating(GameConfiguration.LINE_COUNT - 10, GameConfiguration.COLUMN_COUNT - 4));
		restaurantManager.addTable(tableForEating4);
		restaurantManager.addTakenBlock(tableForEating4.getPosition());
		
		for(int i = 9; i > 4; i--) {
			createOneTable(restaurantManager, i);
		}
		
		for(TableForEating eating : restaurantManager.getTableForEatings()) {
			restaurantManager.addPositionForEating(eating.getPosForEating1());
			restaurantManager.addPositionForEating(eating.getPosForEating2());
		}
		
	}
	
	private void createOneTable(RestaurantManager restaurantManager, int column) {
		TableForEating tableForEating = new TableForEating(
				new Block(GameConfiguration.LINE_COUNT - column, GameConfiguration.COLUMN_COUNT - 1),
				new PositionForEating(GameConfiguration.LINE_COUNT - column, GameConfiguration.COLUMN_COUNT - 2),
				null);
		restaurantManager.addTable(tableForEating);
		restaurantManager.addTakenBlock(tableForEating.getPosition());
	}
	
	/**
	 * Initialize the staff on the restaurant.
	 * @param restaurantManager initialize staff in the RestaurantManager class.
	 */
	private void initCharacters(RestaurantManager restaurantManager) {
		List<Cook> cooks = new ArrayList<Cook>();
		List<Block> takenBlocks = new ArrayList<Block>();

		Block blockCook = new Block(GameConfiguration.COLUMN_COUNT - 2, GameConfiguration.LINE_COUNT - 9);

		cooks.add(new Cook(blockCook, "Philippe", 1000, 4));

		restaurantManager.setCooks(cooks);
		restaurantManager.setTakenBlocks(takenBlocks);
	}

	private void createStorages(RestaurantMap restaurantMap) {
		Block block = restaurantMap.getBlock(GameConfiguration.COLUMN_COUNT - 2, GameConfiguration.LINE_COUNT - 12);

		String[] ingredients = GameConfiguration.INGREDIENT;

		for (int index = 0; index < ingredients.length; index++) {
			addIngredientToStorage(ingredients[index], 100, 50, block);
		}
	}

	private void addIngredientToStorage(String name, int capacityMax, int quantity, Block block) {
		Storage storage = new Storage(block, capacityMax, quantity, name);
		storageMapInstance.addIngredientInStorage(name, storage);

	}

	private void createOvens(RestaurantManager restaurantManager) {
		List<Oven> ovens = new ArrayList<Oven>();

		ovens.add(new Oven(new Block(GameConfiguration.COLUMN_COUNT - 4, GameConfiguration.LINE_COUNT - 12), 5, 4));
		ovens.add(new Oven(new Block(GameConfiguration.COLUMN_COUNT - 5, GameConfiguration.LINE_COUNT - 12), 5, 4));

		restaurantManager.setOvens(ovens);
	}

	private void createCheckouts(RestaurantManager restaurantManager) {
		List<Checkout> checkouts = new ArrayList<Checkout>();

		checkouts.add(new Checkout(new Block(GameConfiguration.COLUMN_COUNT - 2, GameConfiguration.LINE_COUNT - 8),
				10000, 0));

		restaurantManager.setCheckouts(checkouts);
	}

	private void createCounters(RestaurantManager restaurantManager) {
		List<Counter> counters = new ArrayList<Counter>();

		for (int index = 0; index < GameConfiguration.COLUMN_COUNT; index++) {
			counters.add(new Counter(new Block(index, GameConfiguration.COLUMN_COUNT - 8)));
		}

		restaurantManager.setCounters(counters);

	}

	private void createMenu(RestaurantManager restaurantManager) {

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
		ingredients1.add(new Ingredient("Poulet pane", 2));
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

		restaurantManager.setMenus(menus);
	}

}
