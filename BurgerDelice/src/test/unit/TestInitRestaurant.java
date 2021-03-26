package test.unit;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import data.RestaurantMap;
import process.RestaurantBuilder;
import process.RestaurantManager;

public class TestInitRestaurant {

	private RestaurantManager restaurantManager;
	private RestaurantMap restaurantMap;
	private RestaurantBuilder restaurantBuilder;
	
	@Before
	public void prepareTest() {
		restaurantBuilder = new RestaurantBuilder();
		restaurantManager = new RestaurantManager();
		restaurantMap = restaurantBuilder.buildMap();
	}
	
	@Test
	public void testInit() {
		restaurantManager.setCooks(null);
		restaurantManager.setMenus(null);
		restaurantManager.setCounters(null);
		restaurantManager.setCheckouts(null);
		restaurantManager.setCustomers(null);
		restaurantManager.setTakenBlocks(null);
		restaurantManager.setOvens(null);
		restaurantManager.setOrders(null);
		restaurantManager = restaurantBuilder.buildElements(restaurantMap);
		assertNotNull(restaurantManager.getCooks());
		assertNotNull(restaurantManager.getCheckouts());
		assertNotNull(restaurantManager.getCounters());
		assertNotNull(restaurantManager.getCustomers());
		assertNotNull(restaurantManager.getMenus());
		assertNotNull(restaurantManager.getOrders());
		assertNotNull(restaurantManager.getOvens());
		assertNotNull(restaurantManager.getTakenBlocks());
	}
}
