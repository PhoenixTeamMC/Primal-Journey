package pheonixTeam.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pheonixTeam.main.Direction;
import pheonixTeam.main.map.Map;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Super class for every entity.
 * @author CBachman
 *
 */
public class Entity {

	protected SpriteBatch batch;
	protected Texture texture;

	public Direction facing = Direction.RIGHT;

	public Map map;

	public float x;
	public float y;

	/**
	 * If set to true, will be removed next tick.
	 */
	public boolean isDead = false;
	
	//Api for Entities follows
	/**
	 * Called every tick, used to update graphics
	 * @param batch
	 */
	public void display(Batch batch) {batch.draw(texture, x, y, 4, 4);}
	
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
