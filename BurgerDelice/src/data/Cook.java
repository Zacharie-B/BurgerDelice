package data;

public class Cook extends Employee{
	
	private int rating;

	public Cook(Block position, String name, int salary, int rating) {
		super(position, name, salary);
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
