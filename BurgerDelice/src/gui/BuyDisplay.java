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

import process.OrderPayment;
import process.RestaurantManager;
import process.SimulationUtility;

public class BuyDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel basketLabel = new JLabel("Votre crédit : ");

	private MyButton buyButton = new MyButton("Payer");

	private JTextPane basketPane = new JTextPane();
	private JScrollPane jScrollPane = new JScrollPane(basketPane);

	private Dimension preferredSize = new Dimension(250, 100);

	private RestaurantManager restaurantManager;
	private RestaurantOrderDisplay restaurantOrderDisplay;

	private OrderPayment orderPayment;

	public BuyDisplay(RestaurantManager restaurantManager, RestaurantOrderDisplay restaurantOrderDisplay) {
		this.restaurantManager = restaurantManager;
		this.orderPayment = new OrderPayment(restaurantManager);
		this.restaurantOrderDisplay = restaurantOrderDisplay;

		init();
	}

	private void init() {
		setLayout(new BorderLayout());

		basketLabel.setBackground(Color.WHITE);
		basketLabel.setOpaque(true);

		basketPane.setPreferredSize(preferredSize);
		basketPane.setEditable(false);

		buyButton.addActionListener(new BuyBasket());

		add(basketLabel, BorderLayout.NORTH);
		add(jScrollPane);
		add(buyButton, BorderLayout.SOUTH);
	}

	public void updateBasket() {
		String message = "";
		for (Map.Entry<String, Integer> mapentry : restaurantManager.getOrder().getBasket().entrySet()) {
			message += mapentry.getKey() + " : " + mapentry.getValue() + " - "
					+ mapentry.getValue() * SimulationUtility.lookingIngredientToBuy(mapentry.getKey()) + " euros\n";
		}
		basketPane.setText(message);
	}

	private class BuyBasket implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (restaurantManager.paymentVerification() && !restaurantManager.getOrder().isDelivering()
					&& restaurantManager.getOrder().isFinished()) {
				orderPayment.managePayment();
				basketPane.setText("");
				restaurantOrderDisplay.updateOrder();
				basketLabel.setText("Votre crédit : " + (double) Math.round(restaurantManager.getMoney() * 100) / 100);
			}
		}
	}

	public void updateMoney() {
		basketLabel
				.setText("Votre crédit : " + (double) Math.round(restaurantManager.getMoney() * 100) / 100 + " euros");
	}
}
