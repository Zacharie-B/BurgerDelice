package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.GameConfiguration;
import data.Storage;
import data.StorageMap;
import process.RestaurantManager;

public class StorageDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Name of each ingredient display in window.
	 */
	protected JLabel steakLabel = new JLabel("Steak");
	protected JLabel chickenLabel = new JLabel("Poulet pane");
	protected JLabel fishLabel = new JLabel("Fish");
	protected JLabel breadLabel = new JLabel("Pain");
	protected JLabel cheeseLabel = new JLabel("Cheddar");
	protected JLabel tomatoLabel = new JLabel("Tomate");
	protected JLabel saladLabel = new JLabel("Salade");
	protected JLabel onionLabel = new JLabel("Oignon");
	protected JLabel cornichonLabel = new JLabel("Cornichon");
	protected JLabel chipsLabel = new JLabel("Frites moyenne");
	protected JLabel sauceLabel = new JLabel("Sauce");

	/**
	 * Current quantity of each ingredient display in window.
	 */
	protected JLabel steakQuantityLabel = new JLabel();
	protected JLabel chickenQuantityLabel = new JLabel();
	protected JLabel fishQuantityLabel = new JLabel();
	protected JLabel breadQuantityLabel = new JLabel();
	protected JLabel cheeseQuantityLabel = new JLabel();
	protected JLabel tomatoQuantityLabel = new JLabel();
	protected JLabel saladQuantityLabel = new JLabel();
	protected JLabel onionQuantityLabel = new JLabel();
	protected JLabel cornichonQuantityLabel = new JLabel();
	protected JLabel chipsQuantityLabel = new JLabel();
	protected JLabel sauceQuantityLabel = new JLabel();

	/**
	 * Quantity maximum of each ingredient display in window.
	 */
	protected JLabel steakQuantityMaxLabel = new JLabel();
	protected JLabel chickenQuantityMaxLabel = new JLabel();
	protected JLabel fishQuantityMaxLabel = new JLabel();
	protected JLabel breadQuantityMaxLabel = new JLabel();
	protected JLabel cheeseQuantityMaxLabel = new JLabel();
	protected JLabel tomatoQuantityMaxLabel = new JLabel();
	protected JLabel saladQuantityMaxLabel = new JLabel();
	protected JLabel onionQuantityMaxLabel = new JLabel();
	protected JLabel cornichonQuantityMaxLabel = new JLabel();
	protected JLabel chipsQuantityMaxLabel = new JLabel();
	protected JLabel sauceQuantityMaxLabel = new JLabel();

	/**
	 * Buttons to add quantity to basket.
	 */
	protected JButton addSteak = new JButton("Ajouter au panier");
	protected JButton addChicken = new JButton("Ajouter au panier");
	protected JButton addFish = new JButton("Ajouter au panier");
	protected JButton addBread = new JButton("Ajouter au panier");
	protected JButton addCheese = new JButton("Ajouter au panier");
	protected JButton addTomato = new JButton("Ajouter au panier");
	protected JButton addSalad = new JButton("Ajouter au panier");
	protected JButton addOnion = new JButton("Ajouter au panier");
	protected JButton addCornichon = new JButton("Ajouter au panier");
	protected JButton addChips = new JButton("Ajouter au panier");
	protected JButton addSauce = new JButton("Ajouter au panier");

	private StorageMap storageMapInstance = StorageMap.getInstance();

	private Dimension preferredSize = new Dimension(550, 220);

	private RestaurantManager restaurantManager;
	private BuyDisplay buyDisplay;

	public StorageDisplay(RestaurantManager restaurantManager, BuyDisplay buyDisplay) {
		this.restaurantManager = restaurantManager;
		this.buyDisplay = buyDisplay;
		initStoragePanel();
	}

	/**
	 * Initialize the display about storage in the restaurant.
	 */
	public void initStoragePanel() {

		setPreferredSize(preferredSize);
		GridLayout grid = new GridLayout(12, 4);
		grid.setVgap(1);
		setLayout(grid);
		setBackground(Color.WHITE);
		add(new JLabel("Nom"));
		add(new JLabel("Quantité"));
		add(new JLabel("Quantité max"));
		add(new JLabel("Acheter"));

		addStorageLabel(steakLabel, steakQuantityLabel, steakQuantityMaxLabel);
		add(addSteak);
		addSteak.addActionListener(new AddToBasket(0));

		addStorageLabel(chickenLabel, chickenQuantityLabel, chickenQuantityMaxLabel);
		add(addChicken);
		addChicken.addActionListener(new AddToBasket(1));

		addStorageLabel(fishLabel, fishQuantityLabel, fishQuantityMaxLabel);
		add(addFish);
		addFish.addActionListener(new AddToBasket(2));

		addStorageLabel(breadLabel, breadQuantityLabel, breadQuantityMaxLabel);
		add(addBread);
		addBread.addActionListener(new AddToBasket(3));

		addStorageLabel(saladLabel, saladQuantityLabel, saladQuantityMaxLabel);
		add(addCheese);
		addCheese.addActionListener(new AddToBasket(4));

		addStorageLabel(cornichonLabel, cornichonQuantityLabel, cornichonQuantityMaxLabel);
		add(addTomato);
		addTomato.addActionListener(new AddToBasket(5));

		addStorageLabel(cheeseLabel, cheeseQuantityLabel, cheeseQuantityMaxLabel);
		add(addSalad);
		addSalad.addActionListener(new AddToBasket(6));

		addStorageLabel(onionLabel, onionQuantityLabel, onionQuantityMaxLabel);
		add(addOnion);
		addOnion.addActionListener(new AddToBasket(7));

		addStorageLabel(tomatoLabel, tomatoQuantityLabel, tomatoQuantityMaxLabel);
		add(addCornichon);
		addCornichon.addActionListener(new AddToBasket(8));

		addStorageLabel(chipsLabel, chipsQuantityLabel, chipsQuantityMaxLabel);
		add(addChips);
		addChips.addActionListener(new AddToBasket(9));

		addStorageLabel(sauceLabel, sauceQuantityLabel, sauceQuantityMaxLabel);
		add(addSauce);
		addSauce.addActionListener(new AddToBasket(10));

		setVisible(true);
	}

	/**
	 * Add the labels for do the display of ingredients storage.
	 * 
	 * @param jLabel           name of ingredient
	 * @param quantityLabel    actually quantity of one ingredient
	 * @param quantityMaxLabel quantity maximum of one ingredient
	 */
	private void addStorageLabel(JLabel jLabel, JLabel quantityLabel, JLabel quantityMaxLabel) {
		add(jLabel);
		jLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		quantityLabel.setText(
				String.valueOf(storageMapInstance.getIngredientToStorage(jLabel.getText()).getCurrentCapacity()));
		add(quantityLabel);
		quantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		quantityMaxLabel
				.setText(String.valueOf(storageMapInstance.getIngredientToStorage(jLabel.getText()).getCapacityMax()));
		add(quantityMaxLabel);
		quantityMaxLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
//		logger.info(jLabel.getText());
	}

	/**
	 * Allows to display an ingredient in the storage, his quantity and also his
	 * maximum quantity.
	 * 
	 * @param nameOfIngredient which in the storage
	 * @param quantityLabel    quantity of an ingredient in the storage
	 * @param quantityMaxLabel quantity maximum of an ingredient that storage can
	 *                         get
	 */
	private void updateStorageIngredient(JLabel quantityLabel, JLabel quantityMaxLabel, String nameIngredient) {
		Storage storage = storageMapInstance.getIngredientToStorage(nameIngredient);
		quantityLabel.setText(String.valueOf(storage.getCurrentCapacity()));
		quantityMaxLabel.setText(String.valueOf(storage.getCapacityMax()));
	}

	/**
	 * Allows to see the decrease in stock as the orders take by customers or
	 * increase when one delivery is arrived.
	 */
	public void updateStorageDisplay() {

		updateStorageIngredient(steakQuantityLabel, steakQuantityMaxLabel, GameConfiguration.INGREDIENT[0]);
		updateStorageIngredient(chickenQuantityLabel, chickenQuantityMaxLabel, GameConfiguration.INGREDIENT[1]);
		updateStorageIngredient(fishQuantityLabel, fishQuantityMaxLabel, GameConfiguration.INGREDIENT[2]);
		updateStorageIngredient(breadQuantityLabel, breadQuantityMaxLabel, GameConfiguration.INGREDIENT[3]);
		updateStorageIngredient(saladQuantityLabel, saladQuantityMaxLabel, GameConfiguration.INGREDIENT[4]);
		updateStorageIngredient(cornichonQuantityLabel, cornichonQuantityMaxLabel, GameConfiguration.INGREDIENT[5]);
		updateStorageIngredient(cheeseQuantityLabel, cheeseQuantityMaxLabel, GameConfiguration.INGREDIENT[6]);
		updateStorageIngredient(onionQuantityLabel, onionQuantityMaxLabel, GameConfiguration.INGREDIENT[7]);
		updateStorageIngredient(tomatoQuantityLabel, tomatoQuantityMaxLabel, GameConfiguration.INGREDIENT[8]);
		updateStorageIngredient(chipsQuantityLabel, chipsQuantityMaxLabel, GameConfiguration.INGREDIENT[9]);
		updateStorageIngredient(sauceQuantityLabel, sauceQuantityMaxLabel, GameConfiguration.INGREDIENT[10]);

	}

	private class AddToBasket implements ActionListener {

		private int number;

		public AddToBasket(int number) {
			this.number = number;
		}

		public void actionPerformed(ActionEvent e) {
			restaurantManager.getOrder().addBasket(GameConfiguration.INGREDIENT[number]);
			buyDisplay.updateBasket();
		}
	}

}
