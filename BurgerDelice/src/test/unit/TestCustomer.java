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

public class TestCustomer {

	private RestaurantBuilder restaurantBuilder;
	private RestaurantManager restaurantManager;
	private RestaurantMap restaurantMap;
	private Customer customer1;
	private CustomerManager customerManager;

	@Before
	public void prepareTest() {
		this.restaurantBuilder = new RestaurantBuilder();
		this.restaurantMap = this.restaurantBuilder.buildMap();
		this.restaurantManager = this.restaurantBuilder.buildElements(this.restaurantMap);
		this.customerManager = new CustomerManager(this.restaurantManager);

		this.customer1 = new Customer(new Block(GameConfiguration.LINE_ORDER, GameConfiguration.COLUMN_ORDER_RECEPTION),
				1, 1, true, true, 2);

		while (customer1.getTimeWaiting() != GameConfiguration.TIME_FOR_ORDER_RECEPTION) {
			this.customer1.incrementWaitingTime();
		}

		restaurantManager.addCustomer(customer1);
	}

	@Test
	public void testMoveOnTable() {
		boolean findTable1 = false;
		boolean finishEating1 = false;
		for (int index = 0; index < 20; index++) {
			customerManager.moveCustomer();
			if (customer1.getId() == 1 && customer1.isEating()) {
				findTable1 = true;
			}

			if (customer1.getId() == 1 && customer1.getTimeForEat() == 0) {
				finishEating1 = true;
			}
		}
		assertTrue(findTable1);
		assertTrue(finishEating1);

	}

}
