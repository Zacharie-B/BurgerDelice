package data;

public class Server extends Employee{

	private int rapidity;
	
	public Server(Block position, String name, int salary, int rapidity) {
		super(position, name, salary);
		// TODO Auto-generated constructor stub
		this.rapidity = rapidity;
	}

	public int getRapidity() {
		return rapidity;
	}

	public void setRapidity(int rapidity) {
		this.rapidity = rapidity;
	}
}
