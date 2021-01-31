package engine.mobile;

import engine.map.Block;

public abstract class Employee extends Element{
	
	private String name;
	private int salary;
	
	public Employee(Block position, String name, int salary) {
		super(position);
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
