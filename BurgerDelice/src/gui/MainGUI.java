package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainGUI extends JFrame{
	
	private JLabel labelMenu = new JLabel("Menu");
	private JLabel labelStock = new JLabel("Stock");
	
	public MainGUI(String title) {
		super(title);
		
		//init();
		map();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 800);
		setVisible(true);
		//setPreferredSize(preferredSize);
		setResizable(false);
	}
	
	private void map() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel map = new JPanel();
		map.setSize(500, 500);
		map.setBackground(Color.orange);
		
		contentPane.add(map);
	}
	
	private void init() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
        JPanel jpanelHeader = new JPanel();
        jpanelHeader.setLayout(new GridBagLayout());
        jpanelHeader.setBackground(Color.gray);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(30, 30, 30, 30);
        gbc.weightx = 0.2;
        labelMenu.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jpanelHeader.add(labelMenu, gbc);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(30, 30, 30, 30);
        gbc.weightx = 0.8;
		labelStock.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jpanelHeader.add(labelStock, gbc);
        
        
        jpanelHeader.setSize(100, 50);
        contentPane.add(jpanelHeader, BorderLayout.NORTH);
	}
}
