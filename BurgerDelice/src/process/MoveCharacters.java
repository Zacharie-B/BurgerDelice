package process;

import data.Block;

public class MoveCharacters extends BasicMove {

	public void moveTopCollision(Block block, RestaurantManager restaurantManager) {
		Boolean isBlocked = false;
		for (Block takenBlock : restaurantManager.getTakenBlocks()) {
			if (block.getY() - 1 == takenBlock.getY() && block.getX() == takenBlock.getX()) {
				isBlocked = true;
				break;
			}
		}

		if (isBlocked == false) {
			restaurantManager.removeTakenBlock(block);
			moveTop(block);
			restaurantManager.addTakenBlock(block);
		}
	}

	public void moveDownCollision(Block block, RestaurantManager restaurantManager) {
		Boolean isBlocked = false;
		for (Block takenBlock : restaurantManager.getTakenBlocks()) {
			if (block.getY() + 1 == takenBlock.getY() && block.getX() == takenBlock.getX()) {
				isBlocked = true;
				break;
			}
		}

		if (isBlocked == false) {
			restaurantManager.removeTakenBlock(block);
			moveDown(block);
			restaurantManager.addTakenBlock(block);
		}
	}

	public void moveLeftCollision(Block block, RestaurantManager restaurantManager) {
		Boolean isBlocked = false;
		for (Block takenBlock : restaurantManager.getTakenBlocks()) {
			if (block.getY() == takenBlock.getY() && block.getX() - 1 == takenBlock.getX()) {
				isBlocked = true;
				break;
			}
		}

		if (isBlocked == false) {
			restaurantManager.removeTakenBlock(block);
			moveLeft(block);
			restaurantManager.addTakenBlock(block);
		}
	}

	public void moveRightCollision(Block block, RestaurantManager restaurantManager) {
		Boolean isBlocked = false;
		for (Block takenBlock : restaurantManager.getTakenBlocks()) {
			if (block.getY() == takenBlock.getY() && block.getX() + 1 == takenBlock.getX()) {
				isBlocked = true;
				break;
			}
		}

		if (isBlocked == false) {
			restaurantManager.removeTakenBlock(block);
			moveRight(block);
			restaurantManager.addTakenBlock(block);
		}
	}

}
