package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import config.GameConfiguration;
import engine.mobile.Storage;

public class ClickListener extends MouseAdapter {
	
	StorageDisplay storageDisplay;
	
	public ClickListener(StorageDisplay storageDisplay) {
		super();
		this.storageDisplay = storageDisplay;
	}
	
	public void mouseClicked(MouseEvent e) {
		for (Storage storage : MainGUI.manager.getStorages()) {
			if (storage.getPosition().getColumn() == (int) ((e.getX())/GameConfiguration.BLOCK_SIZE) && 
					storage.getPosition().getLine() == (int) ((e.getY()-25)/GameConfiguration.BLOCK_SIZE)) {
				storageDisplay.setVisible(true);
				System.out.println((int) (e.getX())/GameConfiguration.BLOCK_SIZE + " " + (int) (e.getY()-25)/GameConfiguration.BLOCK_SIZE);
				for (Storage secondStorage : MainGUI.manager.getStorages()) {
					if(secondStorage.getName().equals("Steak")) {
						storageDisplay.steakQuantityLabel.setText(""+secondStorage.getCurrentCapacity());
						storageDisplay.steakQuantityMaxLabel.setText(""+secondStorage.getCapacityMax());
					}
					if(secondStorage.getName().equals("Pain")) {
						storageDisplay.breadQuantityLabel.setText(""+secondStorage.getCurrentCapacity());
						storageDisplay.breadQuantityMaxLabel.setText(""+secondStorage.getCapacityMax());
					}
					if(secondStorage.getName().equals("Tomate")) {
						storageDisplay.tomatoQuantityLabel.setText(""+secondStorage.getCurrentCapacity());
						storageDisplay.tomatoQuantityMaxLabel.setText(""+secondStorage.getCapacityMax());
					}
					if(secondStorage.getName().equals("Fromage")) {
						storageDisplay.cheeseQuantityLabel.setText(""+secondStorage.getCurrentCapacity());
						storageDisplay.cheeseQuantityMaxLabel.setText(""+secondStorage.getCapacityMax());
					}
					if(secondStorage.getName().equals("Oignon")) {
						storageDisplay.onionQuantityLabel.setText(""+secondStorage.getCurrentCapacity());
						storageDisplay.onionQuantityMaxLabel.setText(""+secondStorage.getCapacityMax());
					}
					if(secondStorage.getName().equals("Salade")) {
						storageDisplay.saladQuantityLabel.setText(""+secondStorage.getCurrentCapacity());
						storageDisplay.saladQuantityMaxLabel.setText(""+secondStorage.getCapacityMax());
					}
				}
			}
		}
		
	}

}