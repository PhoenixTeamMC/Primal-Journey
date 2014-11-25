package pheonixTeam.main.entity;

import pheonixTeam.main.Direction;
import pheonixTeam.main.Map;

/**
 * Super class for every entity.
 * @author CBachman
 *
 */
public class Entity {

	public Direction facing = Direction.RIGHT;

	public Map map;

	public float x;
	public float y;
	public float z;
	
	/**
	 * If set to true, will be removed next tick.
	 */
	public boolean isDead = false;
	
	//Api for Entities follows
	/**
	 * Called every tick, used to update graphics
	 * @param g
	 */
	public void display(){}
	
	/**
	 * Called every tick, used to update logic. 
	 * @param map
	 */
	public void update(Map map){}

	/**
	 * Called when a entiy is spawned in
	 * @param map
	 */
	public void onSpawn(Map map) {}
	
	/**
	 * Called when an entity is killed
	 * @param map
	 */
	public void onDeath(Map map) {}

}
