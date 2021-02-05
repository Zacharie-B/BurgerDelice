package engine.mobile;

import java.util.HashMap;

public class Meal {
	
	private HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
	
	public Meal(HashMap<String, Integer> ingredients) {
		super();
		this.ingredients = ingredients;
	}
	public HashMap<String, Integer> getIngredients() {
		return ingredients;
	}
	public void setIngredients(HashMap<String, Integer> ingredients) {
		this.ingredients = ingredients;
	}

}
