 package phoenixTeam.entity.living;

 import java.util.ArrayList;
import java.util.List;

import phoenixTeam.entity.Entity;
import phoenixTeam.entity.interfaces.IEntityMovable;
import phoenixTeam.entity.living.familiars.EntityFamiliar;
import phoenixTeam.entity.skills.Skill;
import phoenixTeam.event.entity.EntityDamagedEvent;
import phoenixTeam.util.Direction;
import phoenixTeam.util.Random;

/**
 * @author Strikingwolf, CBachman
 */
public abstract class EntityLiving extends Entity implements IEntityMovable
{

    //Mana
    public int mana = 20;

    public int health = 100;
    
    public List<EntityFamiliar> familiars = new ArrayList<EntityFamiliar>();

    public int skillWanted = 0;
    public List<Skill> skills = new ArrayList<Skill>();

    public Random random = new Random();
    
    public EntityLiving(float x, float y) {
		super(x, y);
	}

    
    /**
     * Used to move an entity
     * @param direction
     */
    @Override
    public void move(Direction direction, float amount) {
        if (direction == Direction.LEFT) {x -= amount; facing = Direction.LEFT;}
        if (direction == Direction.RIGHT) {x += amount; facing = Direction.RIGHT;}
        if (direction == Direction.DOWN) {y -= amount; facing = Direction.DOWN;}
        if (direction == Direction.UP) {y += amount; facing = Direction.UP;}
    }

    @Override
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

    @Override
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
}
