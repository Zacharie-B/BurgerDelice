package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import process.RestaurantManager;

public class OrderDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel basketLabel = new JLabel("Votre commande : ");

	private JLabel stateLabel = new JLabel("Pas de commande");

	private JTextPane basketPane = new JTextPane();
	private JScrollPane jScrollPane = new JScrollPane(basketPane);

	private Dimension preferredSize = new Dimension(100, 180);

	private RestaurantManager restaurantManager;

	public OrderDisplay(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;

		init();
	}

	private void init() {
		setLayout(new BorderLayout());

		basketLabel.setBackground(Color.WHITE);
		basketLabel.setOpaque(true);

		stateLabel.setBackground(Color.WHITE);
		stateLabel.setOpaque(true);

		basketPane.setPreferredSize(preferredSize);

		add(basketLabel, BorderLayout.NORTH);
		add(jScrollPane);
		add(stateLabel, BorderLayout.SOUTH);
	}

	public void updateOrder() {
		String message = "";
		for (Map.Entry<String, Integer> mapentry : restaurantManager.getOrder().getOrder().entrySet()) {
			message += mapentry.getKey() + " : " + mapentry.getValue() + "\n";
		}
		basketPane.setText(message);
	}

	public void updateTime() {
		if (restaurantManager.getOrder().getTimeOrder() == 0) {
			stateLabel.setText("Pas de commande");
		} else if (restaurantManager.getOrder().getTimeOrder() < 10) {
			stateLabel.setText("Commande en préparation");
		} else if (restaurantManager.getOrder().getTimeOrder() < 22) {
			stateLabel.setText("Commande expediée");
		} else if (restaurantManager.getOrder().getTimeOrder() < 29) {
			stateLabel.setText("Commande en livraison");
		} else {
			basketPane.setText("");
		}
	}
}