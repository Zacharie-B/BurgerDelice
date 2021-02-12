package engine.process;

import java.util.List;

import engine.map.Block;

/**
 * Each methods on this class verify the presence on the square where we want to move us.
 *
 */
public class MoveCharacters extends BasicMove{

	public void moveTopCollisionFree(Block blockCustomer, List<Block> takenBlocks) {
		for(Block takenBlock : takenBlocks) {
			if(blockCustomer.getLine() - 1 != takenBlock.getLine() 
					&& blockCustomer.getColumn() == takenBlock.getColumn()) {
				moveTop(blockCustomer);
				break;
			}
		}
	}
	
	public void moveBotCollisionFree(Block blockCustomer, List<Block> takenBlocks) {
		for(Block takenBlock : takenBlocks) {
			if(blockCustomer.getLine() + 1 != takenBlock.getLine() 
					&& blockCustomer.getColumn() == takenBlock.getColumn()) {
				moveBot(blockCustomer);
				break;
			}
		}
	}
	
	public void moveLeftCollisionFree(Block blockCustomer, List<Block> takenBlocks) {
		for(Block takenBlock : takenBlocks) {
			if(blockCustomer.getLine() == takenBlock.getLine() 
					&& blockCustomer.getColumn() - 1 != takenBlock.getColumn()) {
				moveLeft(blockCustomer);
				break;
			}
		}
	}
	
	public void moveRightCollisionFree(Block blockCustomer, List<Block> takenBlocks) {
		for(Block takenBlock : takenBlocks) {
			if(blockCustomer.getLine() == takenBlock.getLine() 
					&& blockCustomer.getColumn() + 1 != takenBlock.getColumn()) {
				moveRight(blockCustomer);
				break;
			}
		}
	}
	
}
