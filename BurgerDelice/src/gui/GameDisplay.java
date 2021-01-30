package gui;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;

import engine.map.Map;
import engine.mobile.Cook;
import engine.mobile.Oven;
import engine.mobile.Storage;
import engine.process.RestaurantManager;

public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private RestaurantManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, RestaurantManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		try {
			paintStrategy.paint(map, g);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for(Cook cook : manager.getCooks()) {
			try {
				paintStrategy.paint(cook, g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(Storage storage : manager.getStorages()) {
			try {
				paintStrategy.paint(storage, g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(Oven oven : manager.getOvens()) {
			try {
				paintStrategy.paint(oven, g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
