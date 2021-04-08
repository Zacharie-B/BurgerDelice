package data;
/**
 * 
 * this class represent a table where you can eat 
 *
 */
public class TableForEating extends Element{
	
	PositionForEating posForEating1;
	PositionForEating posForEating2;
	
	public TableForEating(Block position, PositionForEating posForEating1, PositionForEating posForEating2) {
		super(position);
		this.posForEating1 = posForEating1;
		this.posForEating2 = posForEating2;
	}

	public PositionForEating getPosForEating1() {
		return posForEating1;
	}

	public PositionForEating getPosForEating2() {
		return posForEating2;
	}	
}
