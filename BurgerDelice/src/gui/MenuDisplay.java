package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import engine.process.RestaurantManager;

public class MenuDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JButton changeFirstMenu = new JButton("Menu 1");
	protected JButton changeSecondMenu = new JButton("Menu 2");
	protected JButton changeThirdMenu = new JButton("Menu 3");

	protected JLabel ingredientLabel = new JLabel("INGREDIENT");
	protected JLabel steakLabel = new JLabel("STEAK");
	protected JLabel breadLabel = new JLabel("PAIN");
	protected JLabel cheeseLabel = new JLabel("CHEDDAR");
	protected JLabel tomatoLabel = new JLabel("TOMATE");
	protected JLabel saladLabel = new JLabel("SALADE");
	protected JLabel onionLabel = new JLabel("OIGNON");

	protected JLabel steakQuantityLabel = new JLabel();
	protected JLabel breadQuantityLabel = new JLabel();
	protected JLabel cheeseQuantityLabel = new JLabel();
	protected JLabel tomatoQuantityLabel = new JLabel();
	protected JLabel saladQuantityLabel = new JLabel();
	protected JLabel onionQuantityLabel = new JLabel();

	protected JButton addSteakButton = new JButton("Ajouter");
	protected JButton addBreadButton = new JButton("Ajouter");
	protected JButton addCheeseButton = new JButton("Ajouter");
	protected JButton addTomatoButton = new JButton("Ajouter");
	protected JButton addSaladButton = new JButton("Ajouter");
	protected JButton addOnionButton = new JButton("Ajouter");

	protected JButton removeSteakButton = new JButton("Retirer");
	protected JButton removeBreadButton = new JButton("Retirer");
	protected JButton removeCheeseButton = new JButton("Retirer");
	protected JButton removeTomatoButton = new JButton("Retirer");
	protected JButton removeSaladButton = new JButton("Retirer");
	protected JButton removeOnionButton = new JButton("Retirer");

	protected RestaurantManager restaurantManager;

	private int currentMenu = 0;

	public MenuDisplay(RestaurantManager restaurantManager) {
		this.restaurantManager = restaurantManager;
		initStyle();
		initLayout();
		initActions();
	}

	protected void initStyle() {

		int alignement = (SwingConstants.CENTER);

		ingredientLabel.setHorizontalAlignment(alignement);
		steakLabel.setHorizontalAlignment(alignement);
		steakLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		breadLabel.setHorizontalAlignment(alignement);
		breadLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		cheeseLabel.setHorizontalAlignment(alignement);
		cheeseLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		tomatoLabel.setHorizontalAlignment(alignement);
		tomatoLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		saladLabel.setHorizontalAlignment(alignement);
		saladLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		onionLabel.setHorizontalAlignment(alignement);
		onionLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));

		steakQuantityLabel.setHorizontalAlignment(alignement);
		steakQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		breadQuantityLabel.setHorizontalAlignment(alignement);
		breadQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		cheeseQuantityLabel.setHorizontalAlignment(alignement);
		cheeseQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		tomatoQuantityLabel.setHorizontalAlignment(alignement);
		tomatoQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		saladQuantityLabel.setHorizontalAlignment(alignement);
		saladQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		onionQuantityLabel.setHorizontalAlignment(alignement);
		onionQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));

		changeFirstMenu.setBorderPainted(false);
		changeFirstMenu.setContentAreaFilled(false);
		changeFirstMenu.setBackground(Color.LIGHT_GRAY);
		changeFirstMenu.setOpaque(true);

		changeSecondMenu.setBorderPainted(false);
		changeSecondMenu.setContentAreaFilled(false);

		changeThirdMenu.setBorderPainted(false);
		changeThirdMenu.setContentAreaFilled(false);

	}

	protected void initLayout() {
		GridLayout grid = new GridLayout(7, 4);
		setLayout(grid);
		setBackground(Color.WHITE);

		add(ingredientLabel);
		add(changeFirstMenu);
		add(changeSecondMenu);
		add(changeThirdMenu);

		add(steakLabel);
		add(steakQuantityLabel);
		add(addSteakButton);
		add(removeSteakButton);

		add(breadLabel);
		add(breadQuantityLabel);
		add(addBreadButton);
		add(removeBreadButton);

		add(cheeseLabel);
		add(cheeseQuantityLabel);
		add(addCheeseButton);
		add(removeCheeseButton);

		add(tomatoLabel);
		add(tomatoQuantityLabel);
		add(addTomatoButton);
		add(removeTomatoButton);

		add(saladLabel);
		add(saladQuantityLabel);
		add(addSaladButton);
		add(removeSaladButton);

		add(onionLabel);
		add(onionQuantityLabel);
		add(addOnionButton);
		add(removeOnionButton);

		setVisible(true);
	}

	protected void initActions() {
		changeFirstMenu.addActionListener(new showMenu(0));
		changeSecondMenu.addActionListener(new showMenu(1));
		changeThirdMenu.addActionListener(new showMenu(2));

		addSteakButton.addActionListener(new addIngredient("Steak"));
		addBreadButton.addActionListener(new addIngredient("Pain"));
		addCheeseButton.addActionListener(new addIngredient("Fromage"));
		addTomatoButton.addActionListener(new addIngredient("Tomate"));
		addSaladButton.addActionListener(new addIngredient("Salade"));
		addOnionButton.addActionListener(new addIngredient("Oignon"));

		removeSteakButton.addActionListener(new removeIngredient("Steak"));
		removeBreadButton.addActionListener(new removeIngredient("Pain"));
		removeCheeseButton.addActionListener(new removeIngredient("Fromage"));
		removeTomatoButton.addActionListener(new removeIngredient("Tomate"));
		removeSaladButton.addActionListener(new removeIngredient("Salade"));
		removeOnionButton.addActionListener(new removeIngredient("Oignon"));

	}

	private class showMenu implements ActionListener {

		private int numberOfMenu;

		public showMenu(int numberOfMenu) {
			super();
			this.numberOfMenu = numberOfMenu;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			currentMenu = numberOfMenu;

			if (numberOfMenu == 0) {
				changeFirstMenu.setBackground(Color.LIGHT_GRAY);
				changeSecondMenu.setBackground(Color.WHITE);
				changeThirdMenu.setBackground(Color.WHITE);
			}
			if (numberOfMenu == 1) {
				changeFirstMenu.setBackground(Color.WHITE);
				changeSecondMenu.setBackground(Color.LIGHT_GRAY);
				changeThirdMenu.setBackground(Color.WHITE);
			}
			if (numberOfMenu == 2) {
				changeFirstMenu.setBackground(Color.WHITE);
				changeSecondMenu.setBackground(Color.WHITE);
				changeThirdMenu.setBackground(Color.LIGHT_GRAY);
			}

			changeFirstMenu.setOpaque(true);
			changeSecondMenu.setOpaque(true);
			changeThirdMenu.setOpaque(true);

			if (restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Steak") != null)
				steakQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Steak")));
			else
				steakQuantityLabel.setText("0");
			if (restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Pain") != null)
				breadQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Pain")));
			else
				breadQuantityLabel.setText("0");
			if (restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Salade") != null)
				saladQuantityLabel.setText(Integer
						.toString(restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Salade")));
			else
				saladQuantityLabel.setText("0");
			if (restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Oignon") != null)
				onionQuantityLabel.setText(Integer
						.toString(restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Oignon")));
			else
				onionQuantityLabel.setText("0");
			if (restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Tomate") != null)
				tomatoQuantityLabel.setText(Integer
						.toString(restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Tomate")));
			else
				tomatoQuantityLabel.setText("0");
			if (restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Cheddar") != null)
				cheeseQuantityLabel.setText(Integer
						.toString(restaurantManager.getMenus().get(numberOfMenu).getIngredients().get("Cheddar")));
			else
				cheeseQuantityLabel.setText("0");
		}

	}

	private class addIngredient implements ActionListener {

		private String ingredient;

		public addIngredient(String ingredient) {
			super();
			this.ingredient = ingredient;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (ingredient.equals("Steak")) {
				MainGUI.manager.getMenus().get(currentMenu).addIngredient("Steak");
				steakQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Steak")));
			}
			if (ingredient.equals("Pain")) {
				MainGUI.manager.getMenus().get(currentMenu).addIngredient("Pain");
				breadQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Pain")));
			}
			if (ingredient.equals("Salade")) {
				MainGUI.manager.getMenus().get(currentMenu).addIngredient("Salade");
				saladQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Salade")));
			}
			if (ingredient.equals("Oignon")) {
				MainGUI.manager.getMenus().get(currentMenu).addIngredient("Oignon");
				onionQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Oignon")));
			}
			if (ingredient.equals("Tomate")) {
				MainGUI.manager.getMenus().get(currentMenu).addIngredient("Tomate");
				tomatoQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Tomate")));
			}
			if (ingredient.equals("Fromage")) {
				MainGUI.manager.getMenus().get(currentMenu).addIngredient("Cheddar");
				cheeseQuantityLabel.setText(Integer
						.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Cheddar")));
			}
		}
	}

	private class removeIngredient implements ActionListener {

		private String ingredient;

		public removeIngredient(String ingredient) {
			super();
			this.ingredient = ingredient;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (ingredient.equals("Steak")) {
				MainGUI.manager.getMenus().get(currentMenu).removeIngredient("Steak");
				steakQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Steak")));

			}
			if (ingredient.equals("Pain")) {
				MainGUI.manager.getMenus().get(currentMenu).removeIngredient("Pain");
				breadQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Pain")));

			}

			if (ingredient.equals("Salade")) {
				MainGUI.manager.getMenus().get(currentMenu).removeIngredient("Salade");
				saladQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Salade")));

			}
			if (ingredient.equals("Oignon")) {
				MainGUI.manager.getMenus().get(currentMenu).removeIngredient("Oignon");
				onionQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Oignon")));

				onionQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Oignon")));

			}
			if (ingredient.equals("Tomate")) {
				MainGUI.manager.getMenus().get(currentMenu).removeIngredient("Tomate");
				tomatoQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Tomate")));

				tomatoQuantityLabel.setText(
						Integer.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Tomate")));

			}
			if (ingredient.equals("Fromage")) {
				MainGUI.manager.getMenus().get(currentMenu).removeIngredient("Cheddar");
				cheeseQuantityLabel.setText(Integer
						.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Cheddar")));

				tomatoQuantityLabel.setText(Integer
						.toString(restaurantManager.getMenus().get(currentMenu).getIngredients().get("Cheddar")));

			}
		}
	}
}
