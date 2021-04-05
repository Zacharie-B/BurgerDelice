package test.unit;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data.Ingredient;
import data.Menu;


public class TestStorage {

	private Menu menu;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	@Before
	public void prepareTest() {
		this.ingredients.add(new Ingredient("a", 2));
		this.ingredients.add(new Ingredient("b", 2));
		this.ingredients.add(new Ingredient("c", 3));
		this.menu = new Menu(1, ingredients);
	}
	
	@Test
	public void testAddMenuIngredient() {
		int count1 = 0;
		for(Ingredient ingredient : menu.getIngredients()) {
			if(ingredient.getName().equals("a")) {
				count1 = ingredient.getNbByMenu();
			}
		}
		menu.addIngredient("a");
		int count2 = 0 ;
		for(Ingredient ingredient : menu.getIngredients()) {
			if(ingredient.getName().equals("a")) {
				count2 = ingredient.getNbByMenu();
			}
		}
		assertNotEquals(count1,count2);
	}
	
	@Test
	public void testDecrementMenuIngredient() {
		int count1 = 0;
		for(Ingredient ingredient : menu.getIngredients()) {
			if(ingredient.getName().equals("b")) {
				count1 = ingredient.getNbByMenu();
			}
		}
		menu.decrementIngredient("b");
		int count2 = 0 ;
		for(Ingredient ingredient : menu.getIngredients()) {
			if(ingredient.getName().equals("b")) {
				count2 = ingredient.getNbByMenu();
			}
		}
		assertNotEquals(count1,count2);
	}
}
