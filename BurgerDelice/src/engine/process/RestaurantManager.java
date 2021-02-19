package engine.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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

public class RestaurantManager {
	private Map map;

	private List<Cook> cooks = new ArrayList<Cook>();

	private List<Storage> storages = new ArrayList<Storage>();
	private List<Checkout> checkouts = new ArrayList<Checkout>();
	private List<Oven> ovens = new ArrayList<Oven>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Counter> counters = new ArrayList<Counter>();

	private List<Block> takenBlocks = new ArrayList<Block>();
	private List<Menu> menus = new ArrayList<Menu>();

	private int id = 0;

	private HashMap<Integer, HashMap<String, Integer>> orders = new HashMap<Integer, HashMap<String, Integer>>();

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

	public void add(Integer id, HashMap<String, Integer> ingredients) {
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

	public HashMap<Integer, HashMap<String, Integer>> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<Integer, HashMap<String, Integer>> orders) {
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

	public String toString(Integer key) {
		String message = "N°" + key + " - Commande : ";
		for (Entry<String, Integer> mapentry : orders.get(key).entrySet()) {
			message += mapentry.getKey() + " : " + mapentry.getValue() + " : ";
		}
		return message;
	}

	public int randomNumber(int max) {
		int randomNumber = (int) (Math.random() * max) + 1;
		return randomNumber;
	}

	public void moveStorages(Block position, Storage storage) {
		for (Storage str : storages) {
			if (str.equals(storage)) {
				str.setPosition(position);
			}
		}
	}

	public void generateCustomer() {
		if (randomNumber(5) < 2) {

			Block blockCustomer = new Block(GameConfiguration.LINE_ENTRY, GameConfiguration.COLUMN_ENTRY);

			Customer customer = new Customer(blockCustomer, id, false);

			add(customer);
			add(blockCustomer);
			id++;

		}
	}
}
