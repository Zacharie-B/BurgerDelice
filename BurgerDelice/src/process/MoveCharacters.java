package process;

import data.Block;

/**
 * Manage the characters movement, protecting of the collision. 
 *
 */
public class MoveCharacters extends BasicMove {

	public int moveTopCollision(Block block, RestaurantManager restaurantManager) {
		Boolean isBlocked = false;
		for (Block takenBlock : restaurantManager.getTakenBlocks()) {
			if (block.getY() - 1 == takenBlock.getY() && block.getX() == takenBlock.getX()) {
				isBlocked = true;
				return 1;
			}
		}

		if (isBlocked == false) {
			restaurantManager.removeTakenBlock(block);
			moveTop(block);
			restaurantManager.addTakenBlock(block);
		}
		return 0;
	}

	public int moveDownCollision(Block block, RestaurantManager restaurantManager) {
		Boolean isBlocked = false;
		for (Block takenBlock : restaurantManager.getTakenBlocks()) {
			if (block.getY() + 1 == takenBlock.getY() && block.getX() == takenBlock.getX()) {
				isBlocked = true;
				return 1;
			}
		}

		if (isBlocked == false) {
			restaurantManager.removeTakenBlock(block);
			moveDown(block);
			restaurantManager.addTakenBlock(block);
		}
		return 0;
	}

	public int moveLeftCollision(Block block, RestaurantManager restaurantManager) {
		Boolean isBlocked = false;
		for (Block takenBlock : restaurantManager.getTakenBlocks()) {
			if (block.getY() == takenBlock.getY() && block.getX() - 1 == takenBlock.getX()) {
				isBlocked = true;
				return 1;
			}
		}

		if (isBlocked == false) {
			restaurantManager.removeTakenBlock(block);
			moveLeft(block);
			restaurantManager.addTakenBlock(block);
		}
		return 0;
	}

	public int moveRightCollision(Block block, RestaurantManager restaurantManager) {
		Boolean isBlocked = false;
		for (Block takenBlock : restaurantManager.getTakenBlocks()) {
			if (block.getY() == takenBlock.getY() && block.getX() + 1 == takenBlock.getX()) {
				isBlocked = true;
				return 1;
			}
		}

		if (isBlocked == false) {
			restaurantManager.removeTakenBlock(block);
			moveRight(block);
			restaurantManager.addTakenBlock(block);
		}
		return 0;
	}
}
