package data;

import java.util.HashMap;
import java.util.Map;

public class Stock{
	private Map<Ingredient, Integer> ingredients = new HashMap<Ingredient, Integer>();

	public Stock(Map<Ingredient, Integer> ingredients) {
		super();
		this.ingredients = ingredients;
	}

	public Map<Ingredient, Integer> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Map<Ingredient, Integer> ingredients) {
		this.ingredients = ingredients;
	}
	
	pub
}
