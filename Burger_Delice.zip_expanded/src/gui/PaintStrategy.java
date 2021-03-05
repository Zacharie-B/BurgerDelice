package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import config.GameConfiguration;
import engine.map.Block;
import engine.mobile.Checkout;
import engine.mobile.Cook;
import engine.mobile.Counter;
import engine.mobile.Customer;
import engine.mobile.Oven;
import engine.mobile.Storage;

public class PaintStrategy {

	public void paint(Cook cook, Graphics graphics) throws IOException {
		Block position = cook.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.RED);
		graphics.fillOval(x * blockSize, y * blockSize, blockSize, blockSize);

	}
	
	public void paint(Storage storage, Graphics graphics) throws IOException {
		Block position = storage.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.GRAY);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);

	}
	
	public void paint(Oven oven, Graphics graphics) throws IOException {
		Block position = oven.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.BLACK);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);

	}
	
	public void paint(Customer customer, Graphics graphics) throws IOException {
		Block position = customer.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.BLUE);
		graphics.fillOval(x * blockSize, y * blockSize, blockSize, blockSize);
	}
	
	public void paint(Checkout checkout, Graphics graphics) throws IOException {
		Block position = checkout.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.ORANGE);
		graphics.fillRect( x * blockSize, y * blockSize, blockSize, blockSize);
	}
	
	public void paint(Counter counter, Graphics graphics) throws IOException {
		Block position = counter.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.YELLOW);
		graphics.fillRect( x * blockSize, y * blockSize, blockSize, blockSize);
	}
	
	public void paint(Graphics graphics) throws IOException{
		Block position = new Block(GameConfiguration.LINE_ORDER - 1, GameConfiguration.COLUMN_ORDER_RECEPTION);
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.setColor(Color.MAGENTA);
		graphics.fillRect( x * blockSize, y * blockSize, blockSize, blockSize);
	}
}
