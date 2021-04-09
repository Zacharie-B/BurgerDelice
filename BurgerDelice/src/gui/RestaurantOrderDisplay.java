package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import process.RestaurantManager;
import process.SimulationUtility;

public class RestaurantOrderDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel basketLabel = new JLabel("Pas de commande");

	private MyButton getButton = new MyButton("Récupérer votre commande");

	private JTextPane basketPane = new JTextPane();
	private JScrollPane jScrollPane = new JScrollPane(basketPane);

	private Dimension preferredSize = new Dimension(250, 100);

	private RestaurantManager restaurantManager;

	public RestaurantOrderDisplay(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;

		init();
	}

	private void init() {
		setLayout(new BorderLayout());

		basketLabel.setBackground(Color.WHITE);
		basketLabel.setOpaque(true);

		basketPane.setPreferredSize(preferredSize);

		getButton.addActionListener(new AddToStorage());

		add(basketLabel, BorderLayout.NORTH);
		add(jScrollPane);
		add(getButton, BorderLayout.SOUTH);
	}

	public void updateOrder() {
		String message = "";
		for (Map.Entry<String, Integer> mapentry : restaurantManager.getOrder().getOrder().entrySet()) {
			message += mapentry.getKey() + " : " + mapentry.getValue() + " - " 
				+ mapentry.getValue() * SimulationUtility.lookingIngredientToBuy(mapentry.getKey()) + " euros \n";
		}
		basketPane.setText(message);
	}

	public void updateTime() {
		if (restaurantManager.getOrder().getTimeOrder() == 0) {
			basketPane.setText("");
			basketLabel.setText("Pas de commande");
		} else if (restaurantManager.getOrder().getTimeOrder() < 10) {
			basketLabel.setText("Commande en préparation");
		} else if (restaurantManager.getOrder().getTimeOrder() < 22) {
			basketLabel.setText("Commande expediée");
		} else if (restaurantManager.getOrder().getTimeOrder() < 29) {
			basketLabel.setText("Commande en livraison");
		} else if (restaurantManager.getOrder().getTimeOrder() == 30) {
			basketLabel.setText("Commande livrée");
		}
	}

	private class AddToStorage implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (restaurantManager.getOrder().getTimeOrder() == 30) {
				restaurantManager.addToStorage();
			}
		}
	}
}