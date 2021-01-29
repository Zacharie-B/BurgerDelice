package data;

import java.util.ArrayList;
import java.util.List;

public class Food {
	private String name;
	private int price;	
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	
	public Food(String name, int price, List<Ingredient> ingredients) {
		super();
		this.name = name;
		this.price = price;
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
