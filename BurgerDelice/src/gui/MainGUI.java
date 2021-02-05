package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import config.GameConfiguration;
import engine.map.Map;
import engine.process.ManageCustomer;
import engine.process.RestaurantBuilder;
import engine.process.RestaurantManager;

public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private Map map;
	
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	public static RestaurantManager manager;
	private GameDisplay dashboard;
	private ManagementDisplay managementDashboard;
	private StorageDisplay storageDisplay;
	private ManageCustomer manageCustomer = new ManageCustomer();
	
	private JButton stopButton = new JButton("Stop");
	private boolean status = false;
	private MainGUI instance = this;
		
	public MainGUI(String title) {
		super(title);
		init();
		
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		map = RestaurantBuilder.buildMap();
		manager = RestaurantBuilder.buildInitElement(map);
		dashboard = new GameDisplay(map, manager);
		storageDisplay = new StorageDisplay();
		managementDashboard = new ManagementDisplay(manager, storageDisplay);
		
		dashboard.setPreferredSize(preferredSize);
		managementDashboard.setPreferredSize(preferredSize);
		
		contentPane.add(dashboard, BorderLayout.WEST);
		contentPane.add(managementDashboard, BorderLayout.EAST);
		stopButton.addActionListener(new StartStopAction());
		contentPane.add(stopButton, BorderLayout.SOUTH);
		
		this.addMouseListener(new ClickListener(storageDisplay));
				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(new Dimension(GameConfiguration.WINDOW_WIDTH*2, GameConfiguration.WINDOW_HEIGHT*2));
		setResizable(false);
	}

	@Override
	public void run() {
		while (!status) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
				
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			if(!status) {
				dashboard.repaint();
				managementDashboard.appendOrders();
				manageCustomer();
			}
				
		}
	}
	
	public void manageCustomer() {
		manageCustomer.moveCustomerBeforeOrder();
	}
	
	private class StartStopAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!status) {
				status = true;
				stopButton.setText("Restart");
			} else {
				status = false;
				stopButton.setText("Stop");
				Thread chronoThread = new Thread(instance);
				chronoThread.start();
			}
		}
	}
}
