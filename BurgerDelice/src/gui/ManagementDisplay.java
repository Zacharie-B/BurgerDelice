package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import process.RestaurantManager;

/**
 * Manage the display about information on the orders in preparing, the storage
 * and the menus which choose by the customer by random way.
 *
 */
public class ManagementDisplay extends JPanel implements ItemListener {

	private static final long serialVersionUID = 1L;

	private JPanel cards = new JPanel(new CardLayout());

	private StorageManagementDisplay storageManagementDisplay;
	private MenuManagementDisplay menuManagementDisplay;
	private MenuOrderDisplay menuOrderDisplay;

	private Dimension preferredSize = new Dimension(300, 550);

	/**
	 * Manage the organization on the dashboard, with the restaurant and the storage
	 * in the restaurant.
	 * 
	 * @param manager
	 * @param storageDisplay
	 */
	public ManagementDisplay(RestaurantManager restaurantManager, StorageManagementDisplay storageManagementDisplay,
			MenuOrderDisplay menuOrderDisplay, MenuManagementDisplay menuManagementDisplay) {

		this.storageManagementDisplay = storageManagementDisplay;
		this.menuManagementDisplay = menuManagementDisplay;
		this.menuOrderDisplay = menuOrderDisplay;

		initInformationDisplay();
	}

	/**
	 * Initialize the Border Layout and display this with the orders in preparing,
	 * the storage and the menus.
	 */
	protected void initInformationDisplay() {

		JPanel comboBoxPane = new JPanel(); // Use FlowLayout
		comboBoxPane.setBackground(Color.WHITE);
		String comboBoxItems[] = { "Commande", "Menu", "Stockage" };
		JComboBox<String> cb = new JComboBox<String>(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);

		cards.add(menuOrderDisplay, "Commande");
		cards.add(menuManagementDisplay, "Menu");
		cards.add(storageManagementDisplay, "Stockage");

		storageManagementDisplay.setPreferredSize(preferredSize);
		menuManagementDisplay.setPreferredSize(preferredSize);

		setLayout(new BorderLayout());

		add(comboBoxPane, BorderLayout.NORTH);
		add(cards, BorderLayout.SOUTH);

		setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.LIGHT_GRAY));
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, (String) evt.getItem());
	}

	public StorageManagementDisplay getStorageManagementDisplay() {
		return storageManagementDisplay;
	}

	public MenuManagementDisplay getMenuManagementDisplay() {
		return menuManagementDisplay;
	}

	public MenuOrderDisplay getMenuOrderDisplay() {
		return menuOrderDisplay;
	}

}
