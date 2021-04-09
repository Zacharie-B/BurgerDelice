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
	private IngredientInfoDisplay ingredientInfoDisplay;
	
	private JLabel menuLabel = new JLabel("Modifier les menus");
	private JLabel priceLabel = new JLabel("Prix d'achat et de vente d'ingrédient");

	public MenuManagementDisplay(RestaurantManager restaurantManager) {
		menuDisplay = new MenuDisplay(restaurantManager);
		ingredientInfoDisplay = new IngredientInfoDisplay();
		init();
	}

	public void init() {
		setBackground(Color.WHITE);

		menuLabel.setBackground(new Color(32, 207, 190));
		menuLabel.setOpaque(true);
		menuLabel.setPreferredSize(new Dimension(500, 20));
		menuLabel.setForeground(Color.WHITE);
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		priceLabel.setBackground(new Color(32, 207, 190));
		priceLabel.setOpaque(true);
		priceLabel.setPreferredSize(new Dimension(500, 20));
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

		add(menuLabel);
		add(menuDisplay);
		add(priceLabel);
		add(ingredientInfoDisplay);
	}
}
