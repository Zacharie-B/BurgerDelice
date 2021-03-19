package data;

public class RestaurantMap {
	private Block[][] blocks;

	private int xCount;
	private int yCount;

	public RestaurantMap(int xCount, int yCount) {
		super();
		this.xCount = xCount;
		this.yCount = yCount;
		
		blocks = new Block[xCount][yCount];
		
		for (int xIndex = 0; xIndex < xCount; xIndex++) {
			for (int yIndex = 0; yIndex < yCount; yIndex++) {
				this.blocks[xIndex][yIndex] = new Block(xIndex, yIndex);
			}
		}
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}

	public int getxCount() {
		return xCount;
	}

	public void setxCount(int xCount) {
		this.xCount = xCount;
	}

	public int getyCount() {
		return yCount;
	}

	public void setyCount(int yCount) {
		this.yCount = yCount;
	}
	
	public Block getBlock(int x, int y) {
		return blocks[x][y];
	}

}
