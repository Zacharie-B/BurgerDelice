package data;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Ingredient> meals = new ArrayList<Ingredient>();

	public Menu() {
		
	}
	
	public Menu(List<Ingredient> meals) {
		super();
		this.meals = meals;
	}
	
	public List<Ingredient> getMeals() {
		return meals;
	}
	
	public void setMeals(List<Ingredient> meals) {
		this.meals = meals;
	}

	public void add(Ingredient ingredient) {
		meals.add(ingredient);
	}
	
}
