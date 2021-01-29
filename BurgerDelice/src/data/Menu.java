package data;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Food> meals = new ArrayList<Food>();
	private List<Food> drinks = new ArrayList<Food>();
	private List<Food> desserts = new ArrayList<Food>();
	private Food mealOfTheDay;
	
	
	public Menu(List<Food> meals, List<Food> drinks, List<Food> desserts, Food mealOfTheDay) {
		super();
		this.meals = meals;
		this.drinks = drinks;
		this.desserts = desserts;
		this.mealOfTheDay = mealOfTheDay;
	}
	public List<Food> getMeals() {
		return meals;
	}
	public void setMeals(List<Food> meals) {
		this.meals = meals;
	}
	public List<Food> getDrinks() {
		return drinks;
	}
	public void setDrinks(List<Food> drinks) {
		this.drinks = drinks;
	}
	public List<Food> getDesserts() {
		return desserts;
	}
	public void setDesserts(List<Food> desserts) {
		this.desserts = desserts;
	}
	public Food getMealOfTheDay() {
		return mealOfTheDay;
	}
	public void setMealOfTheDay(Food mealOfTheDay) {
		this.mealOfTheDay = mealOfTheDay;
	}
}
