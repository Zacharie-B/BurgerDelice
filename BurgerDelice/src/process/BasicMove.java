package process;

import data.Block;

/**
 * This class make the base of the move of all elements, we do the movement if
 * there are nobody on this future case.
 *
 */
public class BasicMove {
	
	public Block moveTop(Block block) {
		int y = block.getY();
		y--;
		block.setY(y);
		return block;
	}
	
	public Block moveDown(Block block) {
		int y = block.getY();
		y++;
		block.setY(y);
		return block;
	}
	
	public Block moveLeft(Block block) {
		int x = block.getX();
		x--;
		block.setX(x);
		return block;
	}
	
	public Block moveRight(Block block) {
		int x = block.getX();
		x++;
		block.setX(x);
		return block;
	}
}
