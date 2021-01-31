package engine.process;

import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Cook;
import engine.mobile.Oven;
import engine.mobile.Storage;

public class RestaurantBuilder {
	
	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}
	
	public static RestaurantManager buildInitFurniture(Map map) {
		RestaurantManager furnitureManager = new RestaurantManager(map);
		
		initializeManager(map, furnitureManager);
		
		return furnitureManager;
	}
	
	private static void initializeManager(Map map, RestaurantManager furnitureManager) {
		
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 10, GameConfiguration.COLUMN_COUNT - 2);
		List<Cook> cooks = new ArrayList<Cook>();
		cooks.add(new Cook(block,"Philippe",1000,4));
		
		block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 1 );
		List<Storage> storages = new ArrayList<Storage>();
		storages.add(new Storage(block,100,0,"Steak"));
		
		block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 2);
		storages.add(new Storage(block,100,0,"Pain"));
		
		block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 3 );
		List<Oven> ovens = new ArrayList<Oven>();
		ovens.add(new Oven(block,30,4));
		
		block = map.getBlock(GameConfiguration.LINE_COUNT - 12, GameConfiguration.COLUMN_COUNT - 4 );
		ovens.add(new Oven(block,30,4));
		
		furnitureManager.setCooks(cooks);
		furnitureManager.setStorages(storages);
		furnitureManager.setOvens(ovens);

	}
}
