package process;

import data.Cook;
import data.Server;

/**
 * This class manage the salary of employees in used to all the money of the restaurant.
 * 
 * @author Zacharie
 *
 */
public class PaieOfEmployee {

	private RestaurantManager restaurantManager;
	private int baseTourPaie;
	private int currentTour = 0;
	
	public PaieOfEmployee(RestaurantManager restaurantManager, int baseTourPaie) {
		this.restaurantManager = restaurantManager;
		this.baseTourPaie = baseTourPaie;
	}
	
	/**
	 * Manage all employees payments during the game, we get the money of the restaurant
	 * in order to subtract with the salary of the employees.
	 */
	public void manageEmployeePaiement() {
		double restaurantMoney = restaurantManager.getMoney();
		currentTour++;
		if(baseTourPaie <= currentTour){
			if(restaurantMoney > SimulationUtility.ALL_MONEY_FOR_PAIEMENT) {
				for(Server server : restaurantManager.getServers()) {
					paieServer(server);
				}
				for(Cook cook : restaurantManager.getCooks()) {
					paieCook(cook);
				}
				currentTour = 0;
			}
		}
	}
	
	/**
	 * Subtract the money of the restaurant with the salary of one cook.
	 * @param cook to pay for his job
	 */
	private void paieCook(Cook cook) {
		double salary = (double) cook.getSalary();
		double actualRestaurantMoney = restaurantManager.getMoney();
		restaurantManager.setMoney(actualRestaurantMoney - salary);
	}
	
	/**
	 * Subtract the money of the restaurant with the salary of one server.
	 * @param server to pay for his job
	 */
	private void paieServer(Server server) {
		double salary = (double) server.getSalary();
		double actualRestaurantMoney = restaurantManager.getMoney();
		restaurantManager.setMoney(actualRestaurantMoney - salary);
	}
}
