package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import config.GameConfiguration;
import engine.mobile.Ingredient;
import engine.mobile.Storage;
import engine.process.StorageMap;
import log.LoggerUtility;

public class StorageDisplay extends JPanel {
	
	/**
	 * Name of each ingredient display in window.
	 */
	protected JLabel steakLabel = new JLabel("Steak");
	protected JLabel chickenLabel= new JLabel("Poulet pané");
	protected JLabel fishLabel= new JLabel("Fish");
	protected JLabel breadLabel= new JLabel("Pain");
	protected JLabel cheeseLabel= new JLabel("Cheddar");
	protected JLabel tomatoLabel= new JLabel("Tomate");
	protected JLabel saladLabel= new JLabel("Salade");
	protected JLabel onionLabel= new JLabel("Oignon");
	protected JLabel cornichonLabel= new JLabel("Cornichon");
	protected JLabel chipsLabel= new JLabel("Frites moyenne");
	protected JLabel sauceLabel= new JLabel("Sauce");
	
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
	
	private StorageMap storageMapInstance = StorageMap.getInstance();
	private Logger logger = LoggerUtility.getLogger(StorageDisplay.class, "text");
	
	public StorageDisplay () {
		initStoragePanel();
	}
	
	/**
	 * Initialize the display about storage in the restaurant.
	 */
	public void initStoragePanel() {
		
		GridLayout grid = new GridLayout(12, 3);
		grid.setVgap(1);
		setLayout(grid);
		setBackground(Color.WHITE);
		add(new JLabel("Nom de l'ingrédient"));
		add(new JLabel("Nombre en stock"));
		add(new JLabel("Capacité max de stockage"));
		
		addStorageLabel(steakLabel,steakQuantityLabel, steakQuantityMaxLabel);
		addStorageLabel(chickenLabel,chickenQuantityLabel, chickenQuantityMaxLabel);
		addStorageLabel(fishLabel,fishQuantityLabel, fishQuantityMaxLabel);
		addStorageLabel(breadLabel,breadQuantityLabel, breadQuantityMaxLabel);
		addStorageLabel(saladLabel,saladQuantityLabel, saladQuantityMaxLabel);
		addStorageLabel(cornichonLabel,cornichonQuantityLabel, cornichonQuantityMaxLabel);
		addStorageLabel(cheeseLabel,cheeseQuantityLabel, cheeseQuantityMaxLabel);
		addStorageLabel(onionLabel,onionQuantityLabel, onionQuantityMaxLabel);
		addStorageLabel(tomatoLabel,tomatoQuantityLabel, tomatoQuantityMaxLabel);
		addStorageLabel(chipsLabel,chipsQuantityLabel, chipsQuantityMaxLabel);
		addStorageLabel(sauceLabel,sauceQuantityLabel, sauceQuantityMaxLabel);
		
		setVisible(false);
	}
	
	/**
	 * Add the labels for do the display of ingredients storage.
	 * @param jLabel name of ingredient
	 * @param quantityLabel actually quantity of one ingredient
	 * @param quantityMaxLabel quantity maximum of one ingredient
	 */
	private void addStorageLabel(JLabel jLabel, JLabel quantityLabel, JLabel quantityMaxLabel) {
		add(jLabel);
		jLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		quantityLabel.setText(String.valueOf(storageMapInstance.getIngredientToStorage(jLabel.getText()).getCurrentCapacity()));
		add(quantityLabel);
		quantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		quantityMaxLabel.setText(String.valueOf(storageMapInstance.getIngredientToStorage(jLabel.getText()).getCapacityMax()));
		add(quantityMaxLabel);
		quantityMaxLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
//		logger.info(jLabel.getText());
	}
	
	/**
	 * Allows to display an ingredient in the storage, his quantity and 
	 * also his maximum quantity.
	 * @param nameOfIngredient which in the storage
	 * @param quantityLabel quantity of an ingredient in the storage
	 * @param quantityMaxLabel quantity maximum of an ingredient that storage can get
	 */
	private void updateStorageIngredient(JLabel quantityLabel, JLabel quantityMaxLabel, String nameIngredient) {
		Storage storage = storageMapInstance.getIngredientToStorage(nameIngredient);
		quantityLabel.setText(String.valueOf(storage.getCurrentCapacity()));
		quantityMaxLabel.setText(String.valueOf(storage.getCapacityMax()));
	}
	
	/**
	 * Allows to see the decrease in stock as the orders 
	 * take by customers or increase when one delivery is arrived.
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
		updateStorageIngredient(sauceQuantityLabel, sauceQuantityMaxLabel,GameConfiguration.INGREDIENT[10]);
	}
}
