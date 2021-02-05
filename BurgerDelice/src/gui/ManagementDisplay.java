package gui;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.process.RestaurantManager;

public class ManagementDisplay extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private RestaurantManager manager;
	
	private JTextArea orderDisplay = new JTextArea();	
	
	public ManagementDisplay (RestaurantManager manager) {
		this.manager = manager;
		
		initStyle();
	}
	
	protected void initStyle() {
		add(orderDisplay);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	
	protected void appendOrders() {
		orderDisplay.setText(null);
		for (Entry<String, HashMap<String, Integer>> mapentry : manager.getOrders().entrySet()) {
			orderDisplay.append(manager.toString(mapentry.getKey()) + " \n");
		}
	}
	
	

}
