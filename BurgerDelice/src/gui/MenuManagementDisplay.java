package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import process.RestaurantManager;

public class MenuManagementDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private MenuDisplay menuDisplay;
	private JLabel menuLabel = new JLabel("Modifier les menus");

	public MenuManagementDisplay(RestaurantManager restaurantManager) {
		menuDisplay = new MenuDisplay(restaurantManager);
		init();
	}

	public void init() {
		setBackground(Color.WHITE);

		menuLabel.setBackground(new Color(32, 207, 190));
		menuLabel.setOpaque(true);
		menuLabel.setPreferredSize(new Dimension(500, 20));
		menuLabel.setForeground(Color.WHITE);
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);

		add(menuLabel);
		add(menuDisplay);
	}
}
