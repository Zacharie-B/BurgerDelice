package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import config.GameConfiguration;
import engine.map.Map;
import engine.process.RestaurantBuilder;
import engine.process.RestaurantManager;

public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Map map;
	
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private RestaurantManager manager;

	private GameDisplay dashboard;
		
	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		map = RestaurantBuilder.buildMap();
		manager = RestaurantBuilder.buildInitFurniture(map);
		dashboard = new GameDisplay(map, manager);

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		Boolean status = true;
		while (status) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			dashboard.repaint();
				
		}
	}
}
