package pheonixTeam.main;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import pheonixTeam.main.entity.Entity;

/**
 * 
 * @author chbachman
 *
 */
public class Map {
	
	public Tile[][] tiles;
	
	public Map(int width, int height){
		tiles = new Tile[width][height];
		
		for(int i = 0; i < width; i++){
			for(int g = 0; g < height; g++){
				tiles[i][g] = new Tile(i, g);
			}
		}
	}
	
	public static List<Entity> entityList = new CopyOnWriteArrayList<Entity>();
	
	public static Map getMap(File file){
		return (Map) Main.xml.fromXML(file);
	}
	
	/**
	 * Called each tick, from the update method
	 */
	public void onTick(){
		for(Entity entity: entityList){
			entity.update(this);
			
			if(entity.isDead){
				this.killEntity(entity);
			}
		}
	}
	
	/**
	 * Spawn the entity into the world
	 * @param entity
	 */
	public void spawnEntity(Entity entity){
		
		entity.onSpawn(this);
		
		entityList.add(entity);
	}
	
	/**
	 * Kill the entity
	 * @param entity
	 */
	public void killEntity(Entity entity){
		
		entity.onDeath(this);
		
		entityList.remove(entity);
	}

	/**
	 * Gets the entity at the location given.
	 * @param x
	 * @param y
	 * @param z
	 * @return entity at location, or null if none is found.
	 */
	public Entity getEntityAt(float x, float y, float z) {
		for (Entity entity : entityList) {
			if (entity.x == x && entity.y == y && entity.z == z) {
				return entity;
			}
		}
		return null;
	}

	public void display(){
		
		for (Tile[] tileArray : tiles) {
			for (Tile tile : tileArray) {
				tile.display();
			}
		}
		
		
		for(Entity entity: entityList){
			entity.display();
		}
	}
}
