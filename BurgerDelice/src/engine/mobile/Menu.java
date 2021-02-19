package engine.mobile;

import java.util.HashMap;
import java.util.Map.Entry;

public class Menu {

	private int numberOfMenu;
	private HashMap<String, Integer> ingredients = new HashMap<String, Integer>();

	public Menu(int numberOfMenu, HashMap<String, Integer> ingredients) {
		super();
		this.numberOfMenu = numberOfMenu;
		this.ingredients = ingredients;
	}

	public int getNumberOfMenu() {
		return numberOfMenu;
	}

	public void setNumberOfMenu(int numberOfMenu) {
		this.numberOfMenu = numberOfMenu;
	}

	public HashMap<String, Integer> getIngredients() {
		return ingredients;
	}

	public void setIngredients(HashMap<String, Integer> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredient(String ingredient) {
		if(ingredients.containsKey(ingredient)) {
			for (Entry<String, Integer> entryIngredient : ingredients.entrySet()) {
				if (entryIngredient.getKey().equals(ingredient)) {
					entryIngredient.setValue(entryIngredient.getValue() + 1);
				}
			}
		}
		else {
			ingredients.put(ingredient, 1);
		}
		
	}
	
	public void removeIngredient(String ingredient) {
		
		if(ingredients.containsKey(ingredient)) {
			for (Entry<String, Integer> entryIngredient : ingredients.entrySet()) {
				if (entryIngredient.getKey().equals(ingredient) && ingredients.get(ingredient) > 0) {
					entryIngredient.setValue(entryIngredient.getValue() - 1);
					
				}
			}
		}
		
		
	}
}
