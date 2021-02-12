package config;

public class GameConfiguration {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 600;
	
	public static final int BLOCK_SIZE = 50;
	
	public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
	public static final int GAME_SPEED = 1500;
	
	public static final int LINE_ENTRY = LINE_COUNT - 2;
	public static final int COLUMN_ENTRY = COLUMN_COUNT - 2; // This is also the column of order.
	
	// Position for the recovery of the order.
	public static final int LINE_ORDER = LINE_ENTRY - 5;
	public static final int COLUMN_ORDER_1 = COLUMN_ENTRY;
	public static final int COLUMN_ORDER_2 = COLUMN_ENTRY - 3;
	public static final int COLUMN_ORDER_3 = COLUMN_ENTRY - 6;
	
	// Position for to exit the restaurant.
	public static final int LINE_EXIT = LINE_ENTRY;
	public static final int COLUMN_EXIT = COLUMN_ENTRY - 6;
	
	
	public static final String INGREDIENT[] = {"Steak","Pain","Cheddar","Tomate","Salade","Oignon","Cornichon"};
	
}
