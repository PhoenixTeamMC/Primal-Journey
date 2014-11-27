package pheonixTeam.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import pheonixTeam.main.map.Map;
import pheonixTeam.main.util.Direction;

/**
 * Super class for every entity.
 * @author CBachman
 *
 */
public abstract class Entity {

	protected Texture texture;

	public Direction facing = Direction.RIGHT;

	public Map map;

	public float x;
	public float y;

	public Entity(float x, float y){
		
		this.x = x;
		this.y = y;
		
		texture = new Texture(this.getTextureLocation());
	}
	
	/**
	 * If set to true, will be removed next tick.
	 */
	public boolean isDead = false;
	
	public abstract String getTextureLocation();
	
	//Api for Entities follows
	
	/**
	 * Called every tick, used to update graphics
	 * @param batch
	 */
	public void display(Batch batch) {batch.draw(texture, x, y);}
	
	/**
	 * Called every tick, used to update logic. 
	 * @param map
	 */
	public void update(Map map){}

	/**
	 * Called when a entity is spawned in
	 * @param map
	 */
	public void onSpawn(Map map) {}
	
	/**
	 * Called when an entity is killed
	 * @param map
	 */
	public void onDeath(Map map) {}

}
