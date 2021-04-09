package data;
/**
 * 
 *this class represent a position available to eat on the spot
 *
 */
public class PositionForEating extends Block{

	private boolean isOccuped = false;
	
	public PositionForEating(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public boolean isOccuped() {
		return isOccuped;
	}

	public void setOccuped(boolean isOccuped) {
		this.isOccuped = isOccuped;
	}

	
}
