package gui;

import java.awt.Color;

import javax.swing.JButton;

public class MyButton extends JButton {

	private static final long serialVersionUID = 1L;

	public MyButton(String name) {
		this.setText(name);

		init();
	}

	private void init() {
		setBackground(new Color(32, 207, 190));
		setForeground(Color.WHITE);
		setBorderPainted(false);
	}
}
