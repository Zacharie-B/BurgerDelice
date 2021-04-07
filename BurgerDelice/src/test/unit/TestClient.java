package test.unit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import config.GameConfiguration;
import data.Block;
import data.Customer;
import data.RestaurantMap;
import process.CustomerManager;
import process.RestaurantBuilder;
import process.RestaurantManager;

public class TestClient {
	
	private RestaurantBuilder restaurantBuilder;
	private RestaurantManager restaurantManager;
	private RestaurantMap restaurantMap;
	private Customer customer1;
	private Customer customer2;
	private CustomerManager customerManager;
	
	@Before
	public void prepareTest() {
		this.restaurantBuilder = new RestaurantBuilder();
		this.restaurantMap = this.restaurantBuilder.buildMap();
		this.restaurantManager = this.restaurantBuilder.buildElements(this.restaurantMap);
		this.customerManager = new CustomerManager(this.restaurantManager);
		
		this.customer1 = new Customer(new Block(GameConfiguration.LINE_ORDER + 1, GameConfiguration.COLUMN_ORDER_RECEPTION), 1, 1, false, true, 2);
		this.customer2 = new Customer(new Block(GameConfiguration.LINE_ORDER, GameConfiguration.COLUMN_ORDER_RECEPTION), 2, 2, false, true, 2);
	}
	
	@Test
	public void testMoveOnTable() {
		boolean findTable1 = false;
		boolean findTable2 = false;
		boolean finishEating1 = false;
		boolean finishEating2 = false;
		for(int index=0 ; index<20 ; index++) {
			customerManager.moveCustomer();
			for(Customer customer : restaurantManager.getCustomers()) {
				if(customer.getId() == 1 && customer.isEating()) {
					findTable1 = true;
				}
				if(customer.getId() == 2 && customer.isEating()) {
					findTable2 = true;
				}
				
				if(customer.getId() == 1 && customer.getTimeForEat() == 0) {
					finishEating1 = true;
				}
				if(customer.getId() == 2 && customer.getTimeForEat() == 0) {
					finishEating2 = true;
				}
				
			}
		}
		System.out.println(findTable1);
		assertTrue(findTable1);
		assertTrue(findTable2);
		
		assertTrue(finishEating1);
		assertTrue(finishEating2);
		
	}
	
}
