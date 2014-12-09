package phoenixTeam.entity;

import phoenixTeam.event.EventBus;
import phoenixTeam.event.entity.EntityDamagedEvent;
import phoenixTeam.map.Map;
import phoenixTeam.util.Direction;
import phoenixTeam.util.MathUtil;
import phoenixTeam.util.Random;
import phoenixTeam.util.TextureUtil;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
/**
 * Super class for every entity.
 * @author CBachman
 *
 */
public abstract class Entity {

	protected Texture texture;

	public int health = 100;

	public Direction facing = Direction.RIGHT;

	public float moveSpeed = 0;

	public Map map;

	public float x;
	public float y;
	
	public float targetX;
	public float targetY;

	@SuppressWarnings("unused")
	private Random random;
	
	public Entity(float x, float y){
		EventBus.INSTANCE.register(this);
		random = new Random();
		this.x = x;
		this.y = y;
		
		texture = TextureUtil.getTexture(this.getTextureLocation());
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
	public void update(Map map){
		if(!(x == targetX && y == targetY)){
			this.moveTowards(targetX, targetY);
		}
	}

	/**
	 * Called when a entity is spawned in
	 * @param map
	 */
	public void onSpawn(Map map) {this.map = map;}
	
	/**
	 * Called when an entity is killed
	 * @param map
	 */
	public void onDeath(Map map) {}

	public void moveTo(float x, float y) {
		this.targetX = x;
		this.targetY = y;
	}

	public void damage(int amount) {
		new EntityDamagedEvent(this, amount).callEvent();

		health -= amount;
		if(health <= 0){
			this.isDead = true;
		}
	}

	public void moveTowards(float x, float y){

		float ratio = this.moveSpeed / MathUtil.distance(x, y, this.x, this.y);

		float toMoveX = ratio * (x - this.x);
		float toMoveY = ratio * (y - this.y);
		
		this.x += toMoveX;
		this.y += toMoveY;
	}
}
