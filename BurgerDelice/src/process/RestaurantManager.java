package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.GameConfiguration;
import data.Block;
import data.Checkout;
import data.Cook;
import data.Counter;
import data.Customer;
import data.Ingredient;
import data.Menu;
import data.Order;
import data.Oven;
import data.PositionForEating;
import data.Server;
import data.StorageMap;
import data.TableForEating;

public class RestaurantManager {

	private List<Oven> ovens = new ArrayList<Oven>();
	private List<Checkout> checkouts = new ArrayList<Checkout>();
	private List<Counter> counters = new ArrayList<Counter>();

	private List<Customer> customers = new ArrayList<Customer>();
	private List<Cook> cooks = new ArrayList<Cook>();
	private List<Server> servers = new ArrayList<Server>();

	private List<Block> takenBlocks = new ArrayList<Block>();

	private List<Menu> menus = new ArrayList<Menu>();

	private List<TableForEating> tableForEatings = new ArrayList<TableForEating>();

	private List<PositionForEating> positionForEatings = new ArrayList<PositionForEating>();

	private HashMap<Integer, List<Ingredient>> orders = new HashMap<Integer, List<Ingredient>>();

	private StorageMap storageMapInstance = StorageMap.getInstance();

	private int currentId;
	private double money = 0;

	public Order order = new Order();

	public RestaurantManager() {
		super();
	}

	public void addPositionForEating(PositionForEating positionForEating) {
		positionForEatings.add(positionForEating);
	}

	public void addTable(TableForEating tableForEating) {
		tableForEatings.add(tableForEating);
	}

	public List<TableForEating> getTableForEatings() {
		return tableForEatings;
	}

	public void addMoney(double money) {
		this.money += money;
	}

	public void addOven(Oven oven) {
		ovens.add(oven);
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void addTakenBlock(Block block) {
		takenBlocks.add(block);
	}

	public void add(Integer id, List<Ingredient> ingredients) {
		orders.put(id, ingredients);
	}

	public void removeTakenBlock(Block block) {
		takenBlocks.remove(block);
	}

	public void removeOrder(int id) {
		orders.remove(id);
	}

	public List<Server> getServers() {
		return servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	public List<Oven> getOvens() {
		return ovens;
	}

	public void setOvens(List<Oven> ovens) {
		this.ovens = ovens;
	}

	public List<Checkout> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(List<Checkout> checkouts) {
		this.checkouts = checkouts;
	}

	public List<Counter> getCounters() {
		return counters;
	}

	public void setCounters(List<Counter> counters) {
		this.counters = counters;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Cook> getCooks() {
		return cooks;
	}

	public void setCooks(List<Cook> cooks) {
		this.cooks = cooks;
	}

	public List<Block> getTakenBlocks() {
		return takenBlocks;
	}

	public List<PositionForEating> getPositionForEatings() {
		return positionForEatings;
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

	public HashMap<Integer, List<Ingredient>> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<Integer, List<Ingredient>> orders) {
		this.orders = orders;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String toString(Integer index) {
		String message = "N°" + index + " - Commande : ";
		for (Ingredient ingredient : orders.get(index)) {
			message += ingredient.getName() + " : " + ingredient.getNbByMenu() + " -- ";
		}
		return message;
	}

	public void incrementTimeOrder() {
		if (order.isDelivering()) {
			order.incrementTimeOrder();
		}
		if (order.getTimeOrder() == 30) {
			order.setDelivering(false);
		}
	}

	public void addToStorage() {
		for (Map.Entry<String, Integer> mapentry : order.getOrder().entrySet()) {
			storageMapInstance.addIngredient(mapentry.getKey(), mapentry.getValue());
		}
		order = new Order();

	}

	public void addBasket(String name) {

		if (order.getBasket().get(name) == null) {
			if (storageMapInstance.getIngredientsStorage().get(name).getCurrentCapacity() + 10 <= 100) {
				order.getBasket().put(name, 10);
			}
		} else {
			if (storageMapInstance.getIngredientsStorage().get(name).getCurrentCapacity() + order.getBasket().get(name)
					+ 10 <= 100) {
				order.getBasket().put(name, order.getBasket().get(name) + 10);
			}

		}

	}

	public void removeBasket(String name) {

		if (order.getBasket().get(name) != null) {
			if (order.getBasket().get(name) > 10) {
				order.getBasket().put(name, order.getBasket().get(name) - 10);
			} else if (order.getBasket().get(name) == 10) {
				order.getBasket().remove(name);
			}
		}
	}

	public boolean paymentVerification() {
		double payment = 0;

		for (Map.Entry<String, Integer> mapentry : order.getBasket().entrySet()) {
			payment += mapentry.getValue() * SimulationUtility.lookingForPrice(mapentry.getKey());
		}

		if (money >= payment) {
			return true;

		} else {
			return false;
		}
	}

	public void generateCustomer() {
		if (!takenBlocks.contains(new Block(GameConfiguration.LINE_ENTRY, GameConfiguration.COLUMN_ENTRY))) {
			if (SimulationUtility.getRandom(0, 10) < 2) {
				Block block = new Block(GameConfiguration.LINE_ENTRY, GameConfiguration.COLUMN_ENTRY);
				Customer customer;
				if (SimulationUtility.getRandom(0, 10) < 6) {
					customer = new Customer(block, currentId, SimulationUtility.getRandom(0, 2), false, true,
							SimulationUtility.getRandom(10, 50));
				} else {
					customer = new Customer(block, currentId, SimulationUtility.getRandom(0, 2), false, false, 0);
					if (SimulationUtility.getRandom(0, 10) < 6) {
						customer = new Customer(block, currentId, SimulationUtility.getRandom(0, 2), false, true,
								SimulationUtility.getRandom(10, 50));
					} else {
						customer = new Customer(block, currentId, SimulationUtility.getRandom(0, 2), false, false, 0);
					}
					addCustomer(customer);
					addTakenBlock(block);
					currentId++;
				}
			}
		}
	}
}
