package test.unit;

import org.junit.Before;
import org.junit.Test;

import engine.map.Block;
import engine.mobile.Ingredient;
import engine.mobile.Storage;
import engine.process.ManageCustomer;


public class TestStock {

	private Storage storage;
	private ManageCustomer manageCustomer = new ManageCustomer();
	
	private static final String INGREDIENT_NAME = "tomate";
	
	private Ingredient ingredient;
	
	
	@Before
	public void prepareTest() {
		this.storage = new Storage(new Block(1,1), 100, 80, INGREDIENT_NAME);
		this.ingredient = new Ingredient(INGREDIENT_NAME, 10);
		
	}
	
	@Test
	public void testAddStorage() {
		System.out.println(storage.getCurrentCapacity());
		while(storage.getCurrentCapacity() > 0) {
			manageCustomer.StorageToMenu(storage, ingredient);
		}
		
		assert storage.getCurrentCapacity() == 0;
		System.out.println("Le stockage d'un aliment ne peut pas être négatif");
	}
}
