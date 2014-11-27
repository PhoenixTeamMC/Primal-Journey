package pheonixTeam.main.map;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import pheonixTeam.main.Main;
import pheonixTeam.main.entity.Entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * 
 * @author chbachman
 *
 */
public class Map {
	
	public TiledMap map;
	public OrthogonalTiledMapRenderer renderer;
	
	public final int width;
	public final int height;
	
	public long time = 0;

	
	public Map(int width, int height){
		
		map = new TiledMap();
		renderer = new OrthogonalTiledMapRenderer(map, 1 / 16f);
		
		map.getLayers().add(new TiledMapTileLayer(width, height, 16, 16));
		
		new MapGenerator((TiledMapTileLayer)map.getLayers().get(0)).generate();
		
		this.width = width;
		this.height = height;
		
		/*
		for(int i = 0; i < width; i++){
			for(int g = 0; g < height; g++){
				Tile.DESERT.setTile(i, g, layer);
			}
		}
		*/
	}
	
	public static List<Entity> entityList = new CopyOnWriteArrayList<Entity>();
	
	public static Map getMap(File file){
		return (Map) Main.xml.fromXML(file);
	}
	
	/**
	 * Called each tick, from the update method
	 */
	public void onTick(){
		time++;
		
		for(int i = 0; i < entityList.size(); i++){
			
			Entity entity = entityList.get(i);
			
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
	 * @return entity at location, or null if none is found.
	 */
	public Entity getEntityAt(float x, float y) {
		for (Entity entity : entityList) {
			if (entity.x == x && entity.y == y) {
				return entity;
			}
		}
		return null;
	}

	public void display(OrthographicCamera camera, SpriteBatch batch){
		
		renderer.setView(camera);
		renderer.render();
		
		batch.begin();
		/*
		for (Tile[] tileArray : tiles) {
			for (Tile tile : tileArray) {
				//tile.display(renderer.getSpriteBatch());
			}
		}
		*/
		
		for(Entity entity: entityList){
			entity.display(batch);
		}
		
		batch.end();
	}
}
