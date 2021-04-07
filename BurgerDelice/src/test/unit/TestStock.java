package test.unit;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import data.RestaurantMap;
import process.RestaurantBuilder;

/**
 * the Stock are implemented in the code, we can changer the stocke
 * 
 * @author QA
 *
 */
public class TestStock {
	
	private RestaurantMap restaurantMap;
	private RestaurantBuilder restaurantBuilder;
	
	@Before
	public void prepareTest() {
		this.restaurantBuilder = new RestaurantBuilder();
		this.restaurantMap = restaurantBuilder.buildMap();
	}
	
	@Test
	public void testInitStorage() {
		restaurantBuilder.buildElements(restaurantMap);
	}
	
	@Test
	public void testAddStorage() {
		
	}
}
