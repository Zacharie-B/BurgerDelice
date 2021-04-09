package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import data.Ingredient;
import process.RestaurantManager;

public class MenuOrderDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel moneyLabel = new JLabel();

	private JTextPane orderDisplay = new JTextPane();
	private JScrollPane jScrollPaneOrder = new JScrollPane(orderDisplay);

	private Dimension preferredSize = new Dimension(500, 400);

	private RestaurantManager restaurantManager;

	public MenuOrderDisplay(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;

		init();
	}

	public void init() {
		setBackground(Color.WHITE);

		jScrollPaneOrder.setPreferredSize(preferredSize);

		moneyLabel.setPreferredSize(new Dimension(500, 40));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setBackground(new Color(32, 207, 190));
		moneyLabel.setForeground(Color.WHITE);
		moneyLabel.setOpaque(true);

		add(moneyLabel);
		add(jScrollPaneOrder);
	}

	/**
	 * Display the orders in preparing in a preparing display..
	 */
	protected void orderDisplay() {
		String message = "";
		for (Entry<Integer, List<Ingredient>> mapentry : restaurantManager.getOrders().entrySet()) {
			message += restaurantManager.toString(mapentry.getKey()) + "\n";
		}
		orderDisplay.setText(message);
	}

	protected void moneyDisplay() {
		moneyLabel.setText("Revenu du restaurant : " + (double) Math.round(restaurantManager.getMoney() * 100) / 100
				+ " euros \n");
	}
}
