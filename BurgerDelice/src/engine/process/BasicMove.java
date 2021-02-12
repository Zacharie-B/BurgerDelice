package engine.process;

import engine.map.Block;

/**
 * This class make the base of the move of all elements, we do the movement if
 * there are nobody on this future case.
 *
 */
public class BasicMove {
	
	public Block moveTop(Block block) {
		int line = block.getLine();
		line--;
		block.setLine(line);
		return block;
	}
	
	public Block moveBot(Block block) {
		int line = block.getLine();
		line++;
		block.setLine(line);
		return block;
	}
	
	public Block moveLeft(Block block) {
		int column = block.getColumn();
		column--;
		block.setColumn(column);
		return block;
	}
	
	public Block moveRight(Block block) {
		int column = block.getColumn();
		column++;
		block.setColumn(column);
		return block;
	}
}
