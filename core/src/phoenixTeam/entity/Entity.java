package phoenixTeam.entity;

import phoenixTeam.event.EventBus;
import phoenixTeam.event.entity.EntityDamagedEvent;
import phoenixTeam.map.Map;
import phoenixTeam.util.Direction;
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

	public static float moveSpeed = 0;

	public Map map;

	public float x;
	public float y;

	public Entity(float x, float y){
		EventBus.INSTANCE.register(this);
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
	public void update(Map map){}

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

	/**
	 * Used to move an entity
	 * @param direction
	 */
	public void move(Direction direction, float amount) {
		if (direction == Direction.LEFT) {x -= amount; facing = Direction.LEFT;}
		if (direction == Direction.RIGHT) {x += amount; facing = Direction.RIGHT;}
		if (direction == Direction.DOWN) {y -= amount; facing = Direction.DOWN;}
		if (direction == Direction.UP) {y += amount; facing = Direction.UP;}
	}

	public void moveTo(float x, float y) {
		float xDiff = this.x - x;
		float yDiff = this.y - y;

		if (xDiff < 0) {
			move(Direction.RIGHT, -1 * xDiff);
		} else if (xDiff > 0) {
			move(Direction.LEFT, xDiff);
		}

		if (yDiff < 0) {
			move(Direction.UP, -1 * yDiff);
		} else if (yDiff > 0) {
			move(Direction.DOWN, yDiff);
		}
	}

	public void moveToEntity(Entity entity, float withinX, float withinY) {
		moveTo(entity.x - withinX, entity.y - withinY);
	}

	public void damage(int amount) {
		new EntityDamagedEvent(this, amount).callEvent();


		health -= amount;
		if(health <= 0){
			this.isDead = true;
		}
	}

	public void moveCloserToEntity(Entity entity, float howMuchCloserX, float howMuchCloserY, float withinX, float withinY) {
		float howFarX = (this.x - entity.x);
		float howFarY = (this.y - entity.y);
		float whereToX = entity.x;
		float whereToY = entity.y;

		if (howFarX > 0) {
			whereToX = howFarX - howMuchCloserX + withinX;
		} else if (howFarX < 0) {
			whereToX = howFarX + howMuchCloserX - withinX;
		}

		if (howFarY > 0) {
			whereToY = howFarY - howMuchCloserY + withinY;
		} else if (howFarX < 0) {
			whereToY = howFarY + howMuchCloserY - withinY;
		}

		moveTo(whereToX, whereToY);
	}
}
