package engine.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.RestaurantMap;
import engine.mobile.Checkout;
import engine.mobile.Cook;
import engine.mobile.Counter;
import engine.mobile.Customer;
import engine.mobile.Ingredient;
import engine.mobile.Menu;
import engine.mobile.Oven;
import engine.mobile.Storage;

public class RestaurantManager {
	private RestaurantMap restaurantMap;

	private List<Cook> cooks = new ArrayList<Cook>();
	private List<Checkout> checkouts = new ArrayList<Checkout>();
	private List<Oven> ovens = new ArrayList<Oven>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Counter> counters = new ArrayList<Counter>();

	private List<Block> takenBlocks = new ArrayList<Block>();
	private List<Menu> menus = new ArrayList<Menu>();

	private int id = 0;

	private HashMap<Integer, List<Ingredient>> orders = new HashMap<Integer, List<Ingredient>>();

	public RestaurantManager() {
		
	}
	
	public RestaurantManager(RestaurantMap restaurantMap) {
		this.restaurantMap = restaurantMap;
	}

	public void add(Cook cook) {
		cooks.add(cook);
	}

	public void add(Checkout checkout) {
		checkouts.add(checkout);
	}

	public void add(Oven oven) {
		ovens.add(oven);
	}

	public void add(Customer customer) {
		customers.add(customer);
	}

	public void add(Block block) {
		takenBlocks.add(block);
	}

	public void add(Integer id, List<Ingredient> ingredients) {
		orders.put(id, ingredients);
	}

	public void add(Menu menu) {
		menus.add(menu);
	}

	public void remove(Block block) {
		takenBlocks.remove(block);
	}

	public void remove(Integer id) {
		orders.remove(id);
	}

	public RestaurantMap getMap() {
		return restaurantMap;
	}

	public List<Cook> getCooks() {
		return cooks;
	}

	public void setCooks(List<Cook> cooks) {
		this.cooks = cooks;
	}

	public List<Checkout> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(List<Checkout> checkouts) {
		this.checkouts = checkouts;
	}

	public List<Oven> getOvens() {
		return ovens;
	}

	public void setOvens(List<Oven> ovens) {
		this.ovens = ovens;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Counter> getCounters() {
		return counters;
	}

	public void setCounters(List<Counter> counters) {
		this.counters = counters;
	}

	public void setMap(RestaurantMap restaurantMap) {
		this.restaurantMap = restaurantMap;
	}

	public List<Block> getTakenBlocks() {
		return takenBlocks;
	}

	public void setTakenBlock(List<Block> takenBlock) {
		this.takenBlocks = takenBlock;
	}

	public HashMap<Integer, List<Ingredient>> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<Integer, List<Ingredient>> orders) {
		this.orders = orders;
	}

	public void setTakenBlocks(List<Block> takenBlocks) {
		this.takenBlocks = takenBlocks;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	/**
	 * Create the message of one order which will display in the window.
	 * @param index number of the order
	 * @return message to display in the window
	 */
	public String toString(Integer index) {
		String message = "N°" + index + " - Commande : ";
			for(Ingredient ingredient : orders.get(index)) {
				message += ingredient.getName() + " : " + ingredient.getNbByMenu() + " -- ";
			}
		return message;
	}
	
	/**
	 * Generate a random number between 0 and max in parameter.
	 * @param max value max of random number
	 * @return the random number
	 */
	public int randomNumber(int max) {
		int randomNumber = (int) (Math.random() * max) + 1;
		return randomNumber;
	}

//	public void moveStorages(Block position, Storage storage) {
//		for (Storage str : storages) {
//			if (str.equals(storage)) {
//				str.setPosition(position);
//			}
//		}
//	}

	/**
	 * Generate customers coming in the restaurant if any other customer
	 * is block at entry of restaurant.
	 */
	public void generateCustomer() {
        if(!takenBlocks.contains(new Block(GameConfiguration.LINE_ENTRY, GameConfiguration.COLUMN_ENTRY))) {
            if (randomNumber(5) < 2) {
                Block blockCustomer = new Block(GameConfiguration.LINE_ENTRY, GameConfiguration.COLUMN_ENTRY);
                Customer customer = new Customer(blockCustomer, id, false);
                add(customer);
                add(blockCustomer);
                id++;

            }
        }
    }
}
