package pheonixTeam.main.entity;

import pheonixTeam.main.Direction;
import pheonixTeam.main.entity.interfaces.IEnityDamageable;
import pheonixTeam.main.entity.interfaces.IEntityMovable;

/**
 * @author Strikingwolf
 */
public class EntityLiving extends Entity implements IEnityDamageable, IEntityMovable
{
    public int health = 0;

    /**
     * Used to move an entity
     * @param direction
     */
    @Override
    public void move(Direction direction) {
        if (direction == Direction.LEFT) {x--;}
        if (direction == Direction.RIGHT) {x++;}
        if (direction == Direction.DOWN) {y--;}
        if (direction == Direction.UP) {y++;}
        if (direction == Direction.BACK) {z--;}
        if (direction == Direction.FOWARD) {x++;}
    }

    @Override
    public void damage() {
        health--;
    }
}
