package engine.mobile;

import java.util.HashMap;

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

}
