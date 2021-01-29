package setup;

import java.util.HashMap;

import data.Ingredient;
import data.Menu;

public class CreateMenu {
	
	private HashMap<String, Menu> menus = new HashMap<String, Menu>();
	
	public CreateMenu() {
		
	}
	
	public void creationMenu(String name) {
		
		Menu breakfast = new Menu();
		Menu lunch = new Menu();
		Menu dinner = new Menu();
		
		breakfast.add(new Ingredient("Tomate"));
		breakfast.add(new Ingredient("Oeuf"));
		
		lunch.add(new Ingredient("Steak"));
		
		dinner.add(new Ingredient("Steak"));
		dinner.add(new Ingredient("Pain"));
		dinner.add(new Ingredient("Fromage"));
		
		menus.put("breakfast", breakfast);
		menus.put("lunch", lunch);
		menus.put("dinner", dinner);

	}
}
