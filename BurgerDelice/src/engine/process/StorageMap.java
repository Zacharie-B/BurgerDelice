package engine.process;

import java.util.HashMap;
import java.util.Map;

import engine.mobile.Storage;

public class StorageMap {
	/**
	 * This {@link HashMap} contains all registered variable values. The key is
	 * variable name (unique) and the value is the current variable's value.
	 */
	public Map<String, Storage> ingredientsStorage = new HashMap<String, Storage>();

	/**
	 * The unique instance of the class prepared in an eager way (object created
	 * at beginning).
	 */
	private static StorageMap instance = new StorageMap();

	/**
	 * Private constructor ensuring no access from outside of the class.
	 */
	private StorageMap() {

	}

	/**
	 * Static method allows users to get the unique instance of the class.
	 * 
	 * @return the unique instance of the class.
	 */
	public static StorageMap getInstance() {
		return instance;
	}

	/**
	 * To register the value for a variable, we specify the variable name and
	 * the expected current value for the variable. If there is already a
	 * registered value for the variable with this name, the old value will be
	 * replaced by the new one.
	 * 
	 * @param name
	 *            the name of the variable for which we wish to register the
	 *            (new) value
	 * @param ingredientStorage
	 *            the value for the variable
	 */
	public void addIngredientInStorage(String nameIngredient, Storage ingredientStorage) {
		ingredientsStorage.put(nameIngredient, ingredientStorage);
	}

	/**
	 * Gets the value for a registered variable. If the variable with the
	 * specified name does not exist in the repository, the method returns 0.
	 * 
	 * @param name
	 *            the name of the variable
	 * @return the current registered value for the variable
	 */
	public Storage getIngredientToStorage(String nameIngredient) {
		if (ingredientsStorage.containsKey(nameIngredient)) {
			return ingredientsStorage.get(nameIngredient);
		} else {
			return null;
		} 	
	}
}
