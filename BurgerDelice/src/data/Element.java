package data;
/**
 * 
 * this abstract class represent everything present on the map
 *
 */
public abstract class Element {
	private Block position;

	public Element(Block position) {
		this.position = position;
	}

	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}

}

