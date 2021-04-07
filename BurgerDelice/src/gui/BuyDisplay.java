package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import process.RestaurantManager;

public class BuyDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel basketLabel = new JLabel("Votre panier : ");
	
	private JButton buyButton = new JButton("Payer");

	private JTextPane basketPane = new JTextPane();
	private JScrollPane jScrollPane = new JScrollPane(basketPane);

	private Dimension preferredSize = new Dimension(100, 170);

	private RestaurantManager restaurantManager;

	public BuyDisplay(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;

		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		
		basketLabel.setBackground(Color.WHITE);
		basketLabel.setOpaque(true);

		basketPane.setPreferredSize(preferredSize);

		add(basketLabel, BorderLayout.NORTH);
		add(jScrollPane);
		add(buyButton, BorderLayout.SOUTH);
	}

	public void updateBasket() {
		String message = "";
		for (Map.Entry<String, Integer> mapentry : restaurantManager.getOrder().getBasket().entrySet()) {
			message += mapentry.getKey() + " : " + mapentry.getValue() + "\n";
		}
		basketPane.setText(message);
	}
}
