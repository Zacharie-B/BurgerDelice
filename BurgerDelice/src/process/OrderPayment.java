package process;

import java.util.Map;

public class OrderPayment implements Payment {

	private RestaurantManager restaurantManager;

	public OrderPayment(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
	}

	@Override
	public void managePayment() {
		// TODO Auto-generated method stub
		double payment = 0;

		for (Map.Entry<String, Integer> mapentry : restaurantManager.getOrder().getBasket().entrySet()) {
			payment += mapentry.getValue() * SimulationUtility.lookingIngredientToBuy(mapentry.getKey());
		}

		restaurantManager.setMoney(restaurantManager.getMoney() - payment);
		restaurantManager.getOrder().buyBasket();
		restaurantManager.getOrder().setDelivering(true);

	}
}
