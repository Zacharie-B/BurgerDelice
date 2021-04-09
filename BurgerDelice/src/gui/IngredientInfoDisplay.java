package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import config.GameConfiguration;
import process.SimulationUtility;

public class IngredientInfoDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	/*
	 * Ingredients name in the menu.
	 */
	private JLabel steakLabel = new JLabel();
	private JLabel chickenLabel = new JLabel();
	private JLabel fishLabel = new JLabel();
	private JLabel breadLabel = new JLabel();
	private JLabel cheeseLabel = new JLabel();
	private JLabel tomatoLabel = new JLabel();
	private JLabel saladLabel = new JLabel();
	private JLabel onionLabel = new JLabel();
	private JLabel chipsLabel = new JLabel();
	private JLabel cornichonLabel = new JLabel();
	private JLabel sauceLabel = new JLabel();

	/*
	 * Buy price of each ingredients in the table of display.
	 */
	private JLabel steakBuyPriceLabel = new JLabel();
	private JLabel chickenBuyPriceLabel = new JLabel();
	private JLabel fishBuyPriceLabel = new JLabel();
	private JLabel breadBuyPriceLabel = new JLabel();
	private JLabel cheeseBuyPriceLabel = new JLabel();
	private JLabel tomatoBuyPriceLabel = new JLabel();
	private JLabel saladBuyPriceLabel = new JLabel();
	private JLabel onionBuyPriceLabel = new JLabel();
	private JLabel cornichonBuyPriceLabel = new JLabel();
	private JLabel chipsBuyPriceLabel = new JLabel();
	private JLabel sauceBuyPriceLabel = new JLabel();

	/*
	 * Sell price of each ingredients in the table of display.
	 */
	private JLabel steakSellPriceLabel = new JLabel();
	private JLabel chickenSellPriceLabel = new JLabel();
	private JLabel fishSellPriceLabel = new JLabel();
	private JLabel breadSellPriceLabel = new JLabel();
	private JLabel cheeseSellPriceLabel = new JLabel();
	private JLabel tomatoSellPriceLabel = new JLabel();
	private JLabel saladSellPriceLabel = new JLabel();
	private JLabel onionSellPriceLabel = new JLabel();
	private JLabel cornichonSellPriceLabel = new JLabel();
	private JLabel chipsSellPriceLabel = new JLabel();
	private JLabel sauceSellPriceLabel = new JLabel();

	private int ingredientIndex = 0;
	private Dimension preferredSize = new Dimension(500, 250);

	public IngredientInfoDisplay() {
		init();
		initStyleMenu();
	}

	public void init() {
		GridLayout grid = new GridLayout(12, 3);

		setLayout(grid);
		setBackground(Color.WHITE);
		setPreferredSize(preferredSize);
		
		addInitMenuPanel(steakLabel, steakBuyPriceLabel, steakSellPriceLabel);
		addInitMenuPanel(chickenLabel, chickenBuyPriceLabel, chickenSellPriceLabel);
		addInitMenuPanel(fishLabel, fishBuyPriceLabel, fishSellPriceLabel);
		addInitMenuPanel(breadLabel, breadBuyPriceLabel, breadSellPriceLabel);
		addInitMenuPanel(saladLabel, saladBuyPriceLabel, saladSellPriceLabel);
		addInitMenuPanel(cornichonLabel, cornichonBuyPriceLabel, cornichonSellPriceLabel);
		addInitMenuPanel(cheeseLabel, cheeseBuyPriceLabel, cheeseSellPriceLabel);
		addInitMenuPanel(onionLabel, onionBuyPriceLabel, onionSellPriceLabel);
		addInitMenuPanel(tomatoLabel, tomatoBuyPriceLabel, tomatoSellPriceLabel);
		addInitMenuPanel(chipsLabel, chipsBuyPriceLabel, chipsSellPriceLabel);
		addInitMenuPanel(sauceLabel, sauceBuyPriceLabel, sauceSellPriceLabel);

	}

	private void addInitMenuPanel(JLabel jLabel, JLabel ingredientBuyPriceLabel, JLabel ingredientSellPriceLabel) {
		double price = SimulationUtility.lookingIngredientToBuy(GameConfiguration.INGREDIENT[ingredientIndex]);

		jLabel.setText(GameConfiguration.INGREDIENT[ingredientIndex]);
		ingredientBuyPriceLabel.setText(Math.round(price * 100.0) / 100.0 + " euros");

		price = SimulationUtility.lookingForPrice(GameConfiguration.INGREDIENT[ingredientIndex]);
		ingredientSellPriceLabel.setText(Math.round(price * 100.0) / 100.0 + " euros");

		add(jLabel);
		add(ingredientBuyPriceLabel);
		add(ingredientSellPriceLabel);
		ingredientIndex++;
	}

	private void initStyleMenu() {

		int alignement = (SwingConstants.CENTER);

		/*
		 * Do the style for the name of each ingredient.
		 */
		makeStyleIngredientInMenuPanel(steakLabel, alignement);
		makeStyleIngredientInMenuPanel(chickenLabel, alignement);
		makeStyleIngredientInMenuPanel(fishLabel, alignement);
		makeStyleIngredientInMenuPanel(cornichonLabel, alignement);
		makeStyleIngredientInMenuPanel(breadLabel, alignement);
		makeStyleIngredientInMenuPanel(cheeseLabel, alignement);
		makeStyleIngredientInMenuPanel(tomatoLabel, alignement);
		makeStyleIngredientInMenuPanel(saladLabel, alignement);
		makeStyleIngredientInMenuPanel(onionLabel, alignement);
		makeStyleIngredientInMenuPanel(chipsLabel, alignement);
		makeStyleIngredientInMenuPanel(sauceLabel, alignement);

		/*
		 * Do the style for the BuyPrice and SellPrice of each ingredient.
		 */
		makeStyleIngredientInMenuPanel(steakBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(chickenBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(fishBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(breadBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(cheeseBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(cornichonBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(tomatoBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(saladBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(onionBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(chipsBuyPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(sauceBuyPriceLabel, alignement);

		makeStyleIngredientInMenuPanel(steakSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(chickenSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(fishSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(breadSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(cheeseSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(cornichonSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(tomatoSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(saladSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(onionSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(chipsSellPriceLabel, alignement);
		makeStyleIngredientInMenuPanel(sauceSellPriceLabel, alignement);
	}

	private void makeStyleIngredientInMenuPanel(JLabel jLabel, int alignement) {
		jLabel.setHorizontalAlignment(alignement);
		jLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
	}
}
