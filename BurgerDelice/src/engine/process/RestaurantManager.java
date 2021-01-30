package engine.process;

import java.util.ArrayList;
import java.util.List;

import engine.map.Block;
import engine.map.Map;
import engine.mobile.Checkout;
import engine.mobile.Cook;
import engine.mobile.Oven;
import engine.mobile.Storage;

public class RestaurantManager {
	private Map map;
	
	private List<Cook> cooks = new ArrayList<Cook>();
	
	private List<Storage> storages = new ArrayList<Storage>();
	private List<Checkout> checkouts = new ArrayList<Checkout>();
	private List<Oven> ovens = new ArrayList <Oven>();
	
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

	public List<Oven> getOvens() {
		return ovens;
	}
	
	public void setOvens(List<Oven> ovens) {
		this.ovens = ovens;
	}

	public void moveStorages(Block position, Storage storage) {
		for (Storage str : storages) {
			if(str.equals(storage)) {
				str.setPosition(position);
			}
		}
	}
	
}	
