package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import config.GameConfiguration;
import data.Block;
import data.Checkout;
import data.Cook;
import data.Counter;
import data.Customer;
import data.Oven;
import data.Storage;
import data.TableForEating;

public class PaintStrategy {

	public void paint(Cook cook, Graphics graphics) throws IOException {
		Block position = cook.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getY();
		int x = position.getX();

		graphics.setColor(Color.RED);
		graphics.fillOval(x * blockSize, y * blockSize, blockSize, blockSize);

	}

	public void paint(Storage storage, Graphics graphics) throws IOException {
		Block position = storage.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getY();
		int x = position.getX();

		graphics.setColor(Color.GRAY);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);

	}

	public void paint(Oven oven, Graphics graphics) throws IOException {
		Block position = oven.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getY();
		int x = position.getX();

		graphics.setColor(Color.BLACK);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);

	}

	public void paint(Customer customer, Graphics graphics) throws IOException {
		Block position = customer.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getY();
		int x = position.getX();

		graphics.setColor(Color.BLUE);
		graphics.fillOval(x * blockSize, y * blockSize, blockSize, blockSize);
	}

	public void paint(Checkout checkout, Graphics graphics) throws IOException {
		Block position = checkout.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getY();
		int x = position.getX();

		graphics.setColor(Color.ORANGE);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
	}

	public void paint(Counter counter, Graphics graphics) throws IOException {
		Block position = counter.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getY();
		int x = position.getX();

		graphics.setColor(Color.YELLOW);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
	}

	public void paint(Graphics graphics) throws IOException {
		Block position = new Block(GameConfiguration.COLUMN_ORDER_RECEPTION, GameConfiguration.LINE_ORDER - 1);
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getY();
		int x = position.getX();

		graphics.setColor(Color.MAGENTA);
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
	}
	
	public void paint(TableForEating tableForEating, Graphics graphics) throws IOException {
		Block position = tableForEating.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getY();
		int x = position.getX();

		graphics.setColor(new Color(88, 41, 0));
		graphics.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
		
//		Block eatingPosition1 = tableForEating.getPosForEating1();
//		
//		int y1 = eatingPosition1.getY();
//		int x1 = eatingPosition1.getX();
//		
//		graphics.setColor(new Color(255, 235, 0));
//		graphics.fillOval(x1 * blockSize, y1 * blockSize, blockSize, blockSize);
//		
//		if(tableForEating.getPosForEating2() != null) {
//			Block eatingPosition2 = tableForEating.getPosForEating2();
//			
//			int y2 = eatingPosition2.getY();
//			int x2 = eatingPosition2.getX();
//			
//			graphics.setColor(new Color(255, 235, 0));
//			graphics.fillOval(x2 * blockSize, y2 * blockSize, blockSize, blockSize);
//		}
	} 
}
