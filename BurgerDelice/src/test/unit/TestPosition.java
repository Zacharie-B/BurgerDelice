package test.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import data.Block;
import data.Customer;
import process.MoveCharacters;
import process.RestaurantManager;

public class TestPosition {
	
	private RestaurantManager restaurantManager;
	private Customer customer1Top;
	private Customer customer2;
	private Customer customer3Down;
	private Customer customer4Right;
	private Customer customer5Left;

	@Before
	public void preparePosition() {
		this.restaurantManager = new RestaurantManager();
		this.customer1Top = new Customer(new Block(2, 0), 1, false, true, 2);
		this.customer2 = new Customer(new Block(2, 1), 2, false, true, 2);
		this.customer3Down = new Customer(new Block(2, 2), 2, false, true, 2);
		this.customer4Right = new Customer(new Block(3, 1), 2, false, true, 2);
		this.customer5Left = new Customer(new Block(1, 1), 2, false, true, 2);
		this.restaurantManager.addCustomer(this.customer1Top);
		this.restaurantManager.addCustomer(this.customer2);
		this.restaurantManager.addCustomer(this.customer3Down);
		this.restaurantManager.addCustomer(this.customer4Right);
		this.restaurantManager.addCustomer(this.customer5Left);
		this.restaurantManager.addTakenBlock(this.customer1Top.getPosition());
		this.restaurantManager.addTakenBlock(this.customer2.getPosition());
		this.restaurantManager.addTakenBlock(this.customer3Down.getPosition());
		this.restaurantManager.addTakenBlock(this.customer4Right.getPosition());
		this.restaurantManager.addTakenBlock(this.customer5Left.getPosition());
	}
	
	@Test
	public void testTopCollision() {
		MoveCharacters moveCharacters = new MoveCharacters();
		int y1 = this.customer2.getPosition().getY();
		int x1 = this.customer2.getPosition().getX();
		moveCharacters.moveTopCollision(this.customer2.getPosition(), this.restaurantManager);
		int y2 = this.customer2.getPosition().getY();
		int x2 = this.customer2.getPosition().getX();
		assertEquals(x1,x2);
		assertEquals(y1,y2);
		
	}
	
	@Test
	public void testDownCollision() {
		MoveCharacters moveCharacters = new MoveCharacters();
		int y1 = this.customer2.getPosition().getY();
		int x1 = this.customer2.getPosition().getX();
		moveCharacters.moveDownCollision(this.customer2.getPosition(), this.restaurantManager);
		int y2 = this.customer2.getPosition().getY();
		int x2 = this.customer2.getPosition().getX();
		assertEquals(x1,x2);
		assertEquals(y1,y2);
		
	}
	
	@Test
	public void testLeftCollision() {
		MoveCharacters moveCharacters = new MoveCharacters();
		int y1 = this.customer2.getPosition().getY();
		int x1 = this.customer2.getPosition().getX();
		moveCharacters.moveLeftCollision(this.customer2.getPosition(), this.restaurantManager);
		int y2 = this.customer2.getPosition().getY();
		int x2 = this.customer2.getPosition().getX();
		assertEquals(x1,x2);
		assertEquals(y1,y2);
		
	}
	
	@Test
	public void testRightCollision() {
		MoveCharacters moveCharacters = new MoveCharacters();
		int y1 = this.customer2.getPosition().getY();
		int x1 = this.customer2.getPosition().getX();
		moveCharacters.moveRightCollision(this.customer2.getPosition(), this.restaurantManager);
		int y2 = this.customer2.getPosition().getY();
		int x2 = this.customer2.getPosition().getX();
		assertEquals(x1,x2);
		assertEquals(y1,y2);
		
	}
}