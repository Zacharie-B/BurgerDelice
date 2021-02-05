package engine.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu extends Meal{
	
	private List<Meal> meals = new ArrayList<Meal>();
	
	
	public Menu(HashMap<String, Integer> ingredients, List<Meal> meals) {
		super(ingredients);
		this.meals = meals;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
}
