package engine.process;

import java.util.List;

import engine.map.Block;
import gui.MainGUI;

/**
 * Each method on this class verify the presence on the square where we want to
 * move us.
 *
 */
public class MoveCharacters extends BasicMove {

	public void moveTopCollisionFree(Block blockCustomer, List<Block> takenBlocks) {
		Boolean isBlocked = false;
		for (Block takenBlock : takenBlocks) {
			if (blockCustomer.getLine() - 1 == takenBlock.getLine()
					&& blockCustomer.getColumn() == takenBlock.getColumn()) {
				isBlocked = true;
				break;
			}
		}

		if (isBlocked == false) {
			MainGUI.manager.remove(blockCustomer);
			moveTop(blockCustomer);
			MainGUI.manager.add(blockCustomer);
		}
	}

	public void moveBotCollisionFree(Block blockCustomer, List<Block> takenBlocks) {
		for (Block takenBlock : takenBlocks) {
			if (blockCustomer.getLine() + 1 != takenBlock.getLine()
					&& blockCustomer.getColumn() == takenBlock.getColumn()) {
				moveBot(blockCustomer);
				break;
			}
		}
	}

	public void moveLeftCollisionFree(Block blockCustomer, List<Block> takenBlocks) {
		Boolean isBlocked = false;
		for (Block takenBlock : takenBlocks) {
			if (blockCustomer.getColumn() - 1 == takenBlock.getColumn()
					&& blockCustomer.getLine() == takenBlock.getLine()) {
				isBlocked = true;
				break;
			}
		}

		if (isBlocked == false) {
			MainGUI.manager.remove(blockCustomer);
			moveLeft(blockCustomer);
			MainGUI.manager.add(blockCustomer);
		}

	}

	public void moveRightCollisionFree(Block blockCustomer, List<Block> takenBlocks) {
		for (Block takenBlock : takenBlocks) {
			if (blockCustomer.getLine() == takenBlock.getLine()
					&& blockCustomer.getColumn() + 1 != takenBlock.getColumn()) {
				moveRight(blockCustomer);
				break;
			}
		}
	}

}
