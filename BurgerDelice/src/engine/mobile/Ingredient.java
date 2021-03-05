package engine.mobile;

public class Ingredient {
	private String name;
	private int nbByMenu;
	
	public Ingredient(String name, int nbByMenu) {
		super();
		this.name = name;
		this.nbByMenu = nbByMenu;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNbByMenu() {
		return nbByMenu;
	}
	
	public void setNbByMenu(int nbByMenu) {
		this.nbByMenu = nbByMenu;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", nbByMenu=" + nbByMenu + "]";
	}
	
	
	
}
