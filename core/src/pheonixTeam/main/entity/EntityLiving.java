package pheonixTeam.main.entity;

import pheonixTeam.main.Direction;
import pheonixTeam.main.entity.interfaces.IEnityDamageable;
import pheonixTeam.main.entity.interfaces.IEntityMovable;
import pheonixTeam.main.entity.skills.Skill;

import java.util.List;

/**
 * @author Strikingwolf, CBachman
 */
public class EntityLiving extends Entity implements IEnityDamageable, IEntityMovable
{
    public int health = 100;
    public List<Skill> skills;

    /**
     * Used to move an entity
     * @param direction
     */
    @Override
    public void move(Direction direction, float amount) {
        if (direction == Direction.LEFT) {x = x - amount; facing = Direction.LEFT;}
        if (direction == Direction.RIGHT) {x = x + amount; facing = Direction.RIGHT;}
        if (direction == Direction.DOWN) {y = y- amount;}
        if (direction == Direction.UP) {y = y + amount;}
        if (direction == Direction.BACK) {z = z - amount;}
        if (direction == Direction.FOWARD) {z = z + amount;}
    }

    @Override
    public void damage(int amount) {
        health -= amount;
        if(health <= 0){
        	this.isDead = true;
        }
    }
}
