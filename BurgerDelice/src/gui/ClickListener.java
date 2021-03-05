package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.apache.log4j.Logger;

import config.GameConfiguration;
import log.LoggerUtility;

public class ClickListener extends MouseAdapter {

	private boolean storageIsVisible = false;
	private Logger logger = LoggerUtility.getLogger(ClickListener.class, "text");
	
	public ClickListener() {
		super();
	}

	/**
	 * Display the storage of ingredients for the menu in the windows when 
	 * user click in the gray square, if this display was false.
	 */
	public void mouseClicked(MouseEvent e) {
//		logger.info("Ne lance pas le storage display");
//		logger.info(storageIsVisible);
//		logger.info(GameConfiguration.LINE_COUNT - 2);
//		logger.info((int) ((e.getX()) / GameConfiguration.BLOCK_SIZE));
//		logger.info(GameConfiguration.COLUMN_COUNT - 12);
//		logger.info((int) ((e.getY() - 25) / GameConfiguration.BLOCK_SIZE));
		
		if (GameConfiguration.LINE_COUNT - 2 == (int) ((e.getX()) / GameConfiguration.BLOCK_SIZE)
				&& GameConfiguration.COLUMN_COUNT - 12 == (int) ((e.getY() - 25) / GameConfiguration.BLOCK_SIZE)
				&& storageIsVisible == false) {
			MainGUI.storageDisplay.setVisible(true);
//			logger.info("Cliquez sur le stockge : problème de panel");
			storageIsVisible = true;
		}
	}
}