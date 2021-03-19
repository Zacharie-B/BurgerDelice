package data;

public class TableForEating extends Element{

	private int sizeForcustomer;

	public TableForEating(Block position, int sizeForcustomer) {
		super(position);
		this.sizeForcustomer = sizeForcustomer;
	}

	public int getSizeForcustomer() {
		return sizeForcustomer;
	}
}
