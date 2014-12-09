package phoenixTeam.map;

import java.io.File;
import java.util.ArrayList;

import phoenixTeam.Main;
import phoenixTeam.entity.Entity;
import phoenixTeam.entity.living.player.EntityPlayer;
import phoenixTeam.event.EventBus;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ScreenAdapter;
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
public class Map extends ScreenAdapter{
	
	

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
		
	}
	
	public static ArrayList<Entity> entityList = new ArrayList<Entity>();
	
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


	

	@Override
	public void render(float delta) {
		super.render(delta);
	}
	
	public void display(OrthographicCamera camera, SpriteBatch batch){
		
		renderer.setView(camera);
		renderer.render();
		
		batch.begin();
		
		for(Entity entity: entityList){
			entity.display(batch);
		}
		
		batch.end();
	}
	
	
	/**
	 * Spawn the entity into the world
	 * @param entity
	 */
	public void spawnEntity(Entity entity){
		EventBus.INSTANCE.register(entity);
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
}
