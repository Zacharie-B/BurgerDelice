package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Cook;
import engine.mobile.Oven;
import engine.mobile.Storage;

public class PaintStrategy {
	public void paint(Map map, Graphics graphics) throws IOException {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();
		Image groundImage = ImageIO.read(new File("C:/Users/vofre/git/BurgerDelice/BurgerDelice/sol.jpg"));

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];
				graphics.drawImage(groundImage, block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize, null);
			
			}
		}
	}

	public void paint(Cook cook, Graphics graphics) throws IOException {
		Block position = cook.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image cookImage = ImageIO.read(new File("cook.png"));

		graphics.setColor(Color.BLUE);
		graphics.drawImage(cookImage, x * blockSize, y * blockSize, blockSize, blockSize, null);

	}
	
	public void paint(Storage storage, Graphics graphics) throws IOException {
		Block position = storage.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image cookImage = ImageIO.read(new File("frigo.png"));

		graphics.setColor(Color.BLUE);
		graphics.drawImage(cookImage, x * blockSize, y * blockSize, blockSize, blockSize, null);

	}
	
	public void paint(Oven oven, Graphics graphics) throws IOException {
		Block position = oven.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image cookImage = ImageIO.read(new File("four.png"));

		graphics.setColor(Color.BLUE);
		graphics.drawImage(cookImage, x * blockSize , y * blockSize , blockSize , blockSize , null);

	}
}
