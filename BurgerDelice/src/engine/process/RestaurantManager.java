package engine.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import engine.map.Block;
import engine.map.Map;
import engine.mobile.Checkout;
import engine.mobile.Cook;
import engine.mobile.Counter;
import engine.mobile.Customer;
import engine.mobile.Meal;
import engine.mobile.Oven;
import engine.mobile.Storage;

public class RestaurantManager {
	private Map map;
	
	private List<Cook> cooks = new ArrayList<Cook>();
	
	private List<Storage> storages = new ArrayList<Storage>();
	private List<Checkout> checkouts = new ArrayList<Checkout>();
	private List<Oven> ovens = new ArrayList <Oven>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Counter> counters = new ArrayList<Counter>();
	
	private List<Block> takenBlocks = new ArrayList<Block>();
	private List<Meal> meals = new ArrayList<Meal>();
	
	private HashMap<String, HashMap<String, Integer>> orders = new HashMap<String, HashMap<String, Integer>>();

	public RestaurantManager(Map map) {
		this.map = map;
	}
	
	public void add(Cook cook) {
		cooks.add(cook);
	}
	
	public void add(Storage storage) {
		storages.add(storage);
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
	
	public void add(String name, HashMap<String, Integer> ingredients) {
		orders.put(name, ingredients);
	}
	
	public void add(Meal meal) {
		meals.add(meal);
	}
	
	public void remove(Block block) {
		takenBlocks.remove(block);
	}
	
	public void remove(String name) {
		orders.remove(name);
	}
	
	public Map getMap() {
		return map;
	}

	public List<Cook> getCooks() {
		return cooks;
	}

	public void setCooks(List<Cook> cooks) {
		this.cooks = cooks;
	}

	public List<Storage> getStorages() {
		return storages;
	}
	
	public void setStorages(List<Storage> storages) {
		this.storages = storages;
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

	public void setMap(Map map) {
		this.map = map;
	}

	public List<Block> getTakenBlocks() {
		return takenBlocks;
	}

	public void setTakenBlock(List<Block> takenBlock) {
		this.takenBlocks = takenBlock;
	}
	
	public HashMap<String, HashMap<String, Integer>> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<String, HashMap<String, Integer>> orders) {
		this.orders = orders;
	}

	public void setTakenBlocks(List<Block> takenBlocks) {
		this.takenBlocks = takenBlocks;
	}

	public List<Meal> getMenus() {
		return meals;
	}

	public void setMenus(List<Meal> meals) {
		this.meals = meals;
	}
	
	public String toString(String key) {
		String message = key + "\t Commande : ";
		for (Entry<String, Integer> mapentry : orders.get(key).entrySet()) {
			message += mapentry.getKey() + " : " + mapentry.getValue() + " : ";			
		}
		return message;
	}
	
	public int randomNumber(int max) {
		int randomNumber = (int)(Math.random() * max) + 1;
		return randomNumber;
	}

	public void moveStorages(Block position, Storage storage) {
		for (Storage str : storages) {
			if(str.equals(storage)) {
				str.setPosition(position);
			}
		}
	}
	
}	
