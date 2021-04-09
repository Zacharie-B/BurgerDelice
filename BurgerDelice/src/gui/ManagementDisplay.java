package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import data.Ingredient;
import process.RestaurantManager;

/**
 * Manage the display about information on the orders in preparing, the storage
 * and the menus which choose by the customer by random way.
 *
 */
public class ManagementDisplay extends JPanel implements ItemListener {

	private static final long serialVersionUID = 1L;

	private RestaurantManager restaurantManager;

	private JPanel cards = new JPanel(new CardLayout());

	private JLabel moneyLabel = new JLabel();

	private JTextPane orderDisplay = new JTextPane();
	private StorageManagementDisplay storageManagementDisplay;
	private MenuManagementDisplay menuManagementDisplay;

	private Dimension preferredSize = new Dimension(300, 550);

	/**
	 * Manage the organization on the dashboard, with the restaurant and the storage
	 * in the restaurant.
	 * 
	 * @param manager
	 * @param storageDisplay
	 */
	public ManagementDisplay(RestaurantManager restaurantManager, StorageManagementDisplay storageManagementDisplay,
			MenuManagementDisplay menuManagementDisplay) {
		this.restaurantManager = restaurantManager;
		this.storageManagementDisplay = storageManagementDisplay;
		this.menuManagementDisplay = menuManagementDisplay;

		initInformationDisplay();
	}

	/**
	 * Initialize the Border Layout and display this with the orders in preparing,
	 * the storage and the menus.
	 */
	protected void initInformationDisplay() {
		JPanel comboBoxPane = new JPanel(); // use FlowLayout
		comboBoxPane.setBackground(Color.WHITE);
		String comboBoxItems[] = { "Commande", "Menu", "Stockage" };
		JComboBox<String> cb = new JComboBox<String>(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);

		moneyLabel.setPreferredSize(new Dimension(500, 20));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setBackground(new Color(32, 207, 190));
		moneyLabel.setForeground(Color.WHITE);
		moneyLabel.setOpaque(true);

		JScrollPane jScrollPaneOrder = new JScrollPane(orderDisplay);

		cards.add(jScrollPaneOrder, "Commande");
		cards.add(menuManagementDisplay, "Menu");
		cards.add(storageManagementDisplay, "Stockage");

		storageManagementDisplay.setPreferredSize(preferredSize);
		jScrollPaneOrder.setPreferredSize(preferredSize);
		menuManagementDisplay.setPreferredSize(preferredSize);

		setLayout(new BorderLayout());
		add(comboBoxPane, BorderLayout.NORTH);
		add(moneyLabel, BorderLayout.CENTER);
		add(cards, BorderLayout.SOUTH);

		setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		setVisible(true);
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

	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, (String) evt.getItem());
	}

}
