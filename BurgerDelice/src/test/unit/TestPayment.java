package test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import config.GameConfiguration;
import data.Block;
import data.Customer;
import data.RestaurantMap;
import process.CustomerManager;
import process.OrderPayment;
import process.PayOfEmployee;
import process.Payment;
import process.RestaurantBuilder;
import process.RestaurantManager;

public class TestPayment {

	private RestaurantManager restaurantManager;
	private RestaurantBuilder restaurantBuilder;
	private RestaurantMap restaurantMap;
	private CustomerManager customerManager;
	private Customer customer;
	private Payment payOfEmployee;
	private Payment orderPayment;
	
	@Before
	public void prepareTest() {
		Block block = new Block(GameConfiguration.LINE_ORDER, GameConfiguration.COLUMN_ENTRY);
		this.customer = new Customer(block, 1, 1, false, true, 2);
		this.restaurantManager = new RestaurantManager();
		this.restaurantBuilder = new RestaurantBuilder();
		this.restaurantMap = restaurantBuilder.buildMap();
		this.restaurantManager = this.restaurantBuilder.buildElements(this.restaurantMap);
		this.customerManager = new CustomerManager(this.restaurantManager);
		this.restaurantManager.addCustomer(this.customer);
		this.restaurantManager.addTakenBlock(block);
		this.orderPayment = new OrderPayment(restaurantManager);
		
		this.payOfEmployee = new PayOfEmployee(restaurantManager, 1);
	}
	
	@Test
	public void testPaymentMenu() {
		assertEquals(0, (long) this.restaurantManager.getMoney());
		for(int time=0 ; time<5 ; time++) {
			customerManager.moveCustomer();
		}
		assertNotEquals(0, this.restaurantManager.getMoney());
	}
	
	@Test
	public void testPayOfEmployee() {
		this.restaurantManager.addMoney(100000);
		assertEquals(100000, (long) this.restaurantManager.getMoney());
		this.payOfEmployee.managePayment();
		assertNotEquals(100000, this.restaurantManager.getMoney());
	}
	
	@Test
	public void testPaymentOrder() {
		this.restaurantManager.addBasket("Steak");
		this.restaurantManager.addMoney(100000);
		assertEquals(100000, (long) this.restaurantManager.getMoney());
		this.orderPayment.managePayment();
		assertNotEquals(100000, this.restaurantManager.getMoney());
		
	}
}
