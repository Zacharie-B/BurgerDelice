package data;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private int numberOfMenu;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	public Menu(int numberOfMenu, List<Ingredient> ingredients) {
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

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void addIngredient(String ingredient) {
		for (Ingredient ingredient2 : ingredients) {
			if (ingredient2.getName().equals(ingredient)) {
				ingredient2.setNbByMenu(ingredient2.getNbByMenu() + 1);
			}
		}
	}

	public void decrementIngredient(String ingredient) {
		for (Ingredient ingredient2 : ingredients) {
			if (ingredient2.getName().equals(ingredient) && ingredient2.getNbByMenu() > 0) {
				ingredient2.setNbByMenu(ingredient2.getNbByMenu() - 1);
			}
		}
	}

}
