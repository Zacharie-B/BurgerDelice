package data;

/**
 * 
 * This class represents a block of the map.
 * 
 * Each element has a block in position. 
 *
 */
public class Block {
	
	/**
	 * In an coordinate system, 
	 * x matches to the value obtained by projecting this point on the horizontal axis.
	 */
	private int x;
	/**
	 * In an coordinate system, 
	 * y matches to the value obtained by projecting this point on the vertical axis.
	 */
	private int y;

	public Block(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Block [x=" + x + ", y=" + y + "]";
	}

	
}
