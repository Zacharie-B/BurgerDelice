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
import data.Server;
import data.Storage;
import data.TableForEating;

public class PaintStrategy {

	public void paint(Cook cook, Graphics graphics) throws IOException {
		Block position = cook.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		
		int y = position.getY();
		int x = position.getX();

		graphics.setColor(Color.LIGHT_GRAY);
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

		if(customer.isHappiness())
			graphics.setColor(Color.BLUE);
		else
			graphics.setColor(Color.RED);
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
	
	public void paint(Server server, Graphics graphics) throws IOException {
		Block position = server.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;
		
		int y = position.getY();
		int x = position.getX();
		
		graphics.setColor(Color.GREEN);
		graphics.fillOval(x * blockSize, y * blockSize, blockSize, blockSize);
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
	} 
}
