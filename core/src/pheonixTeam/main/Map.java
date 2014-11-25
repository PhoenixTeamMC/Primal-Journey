package pheonixTeam.main;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import pheonixTeam.main.entity.Entity;
import pheonixTeam.main.entity.EntityVoid;

public class Map {
	
	public Tile[][] tiles;
	
	public Map(int width, int height){
		for(int i = 0; i < tiles.length; i++){
			for(int g = 0; g < tiles[i].length; g++){
				tiles[i][g] = new Tile(width, height);
			}
		}
	}
	
	public static List<Entity> entityList = new CopyOnWriteArrayList<Entity>();
	
	public static Map getMap(File file){
		return (Map) Main.xml.fromXML(file);
	}
	
	public void onTick(){
		for(Entity entity: entityList){
			entity.update(this);
			
			if(entity.isDead){
				this.killEntity(entity);
			}
		}
	}
	
	public void spawnEntity(Entity entity){
		
		entity.onSpawn(this);
		
		entityList.add(entity);
	}
	
	public void killEntity(Entity entity){
		
		entity.onDeath(this);
		
		entityList.remove(entity);
	}

	public Entity getEntityAt(float x, float y, float z) {
		for (Entity entity : entityList) {
			if (entity.x == x && entity.y == y && entity.z == z) {
				return entity;
			}
		}
		return null;
	}

	public void display(){
		for (Tile[] tile : tiles) {
			for (Tile aTile : tile) {
				aTile.display();
			}
		}
	}
}
