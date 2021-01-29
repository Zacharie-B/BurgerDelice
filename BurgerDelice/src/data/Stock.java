package data;

import java.util.HashMap;
import java.util.Map;

public class Stock {
	
	private Map <Ingredient, Integer> stock = new HashMap <Ingredient, Integer>();
	
	public Stock (HashMap <Ingredient, Integer> stock) {
		this.stock = stock;
	}

	public Map<Ingredient, Integer> getStock() {
		return stock;
	}

	public void setStock(Map<Ingredient, Integer> stock) {
		this.stock = stock;
	}
	
	public void add(Ingredient ingredient, int quantite) {
		if(!stock.containsKey(ingredient)) {
			stock.put(ingredient, quantite);
		}
		else {
			stock.put(ingredient, stock.get(ingredient) + quantite);
		}
	}
	
	public void remove(Ingredient ingredient, int quantite) throws IllegalArgumentException {
		if(stock.get(ingredient) - quantite < 0) {
			throw new IllegalArgumentException("Invalide parameter");
		}
		
		if(stock.containsKey(ingredient)) {
			stock.put(ingredient, stock.get(ingredient) - quantite);
		}
		else {
			throw new IllegalArgumentException("Invalide parameter");
		}
	}

}
