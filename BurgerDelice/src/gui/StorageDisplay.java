package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StorageDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	protected JLabel steakQuantityMaxLabel = new JLabel();
	protected JLabel breadQuantityMaxLabel = new JLabel();
	protected JLabel cheeseQuantityMaxLabel = new JLabel();
	protected JLabel tomatoQuantityMaxLabel = new JLabel();
	protected JLabel saladQuantityMaxLabel = new JLabel();
	protected JLabel onionQuantityMaxLabel = new JLabel();
	
	public StorageDisplay () {
		initStyle();
	}
	
	protected void initStyle() {
		GridLayout grid = new GridLayout(6, 2, 4 ,4);
		grid.setVgap(10);
		setLayout(grid);
		setBackground(Color.WHITE);
		
		add(steakLabel);
		steakLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(steakQuantityLabel);
		steakQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(steakQuantityMaxLabel);
		steakQuantityMaxLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		
		add(breadLabel);
		breadLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(breadQuantityLabel);
		breadQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(breadQuantityMaxLabel);
		breadQuantityMaxLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		
		add(cheeseLabel);
		cheeseLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(cheeseQuantityLabel);
		cheeseQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(cheeseQuantityMaxLabel);
		cheeseQuantityMaxLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		
		add(tomatoLabel);
		tomatoLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(tomatoQuantityLabel);
		tomatoQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(tomatoQuantityMaxLabel);
		tomatoQuantityMaxLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		
		add(saladLabel);
		saladLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(saladQuantityLabel);
		saladQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(saladQuantityMaxLabel);
		saladQuantityMaxLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		
		add(onionLabel);
		onionLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(onionQuantityLabel);
		onionQuantityLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		add(onionQuantityMaxLabel);
		onionQuantityMaxLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray));
		
		setVisible(false);
		
	}

}
