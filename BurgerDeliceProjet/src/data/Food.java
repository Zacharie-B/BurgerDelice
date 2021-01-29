package data;

import java.util.ArrayList;

public class Food {
	
	private String name;
	private int price;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Food (String name, int price, ArrayList<Ingredient> ingredients) {
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

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
