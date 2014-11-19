package pheonixTeam.main.entity;

import pheonixTeam.main.Direction;
import pheonixTeam.main.entity.interfaces.IEnityDamageable;
import pheonixTeam.main.entity.interfaces.IEntityMovable;

/**
 * @author SatanicSanta, Strikingwolf
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
        if (direction == Direction.Left) {x--;}
        if (direction == Direction.Right) {x++;}
        if (direction == Direction.Down) {y--;}
        if (direction == Direction.Up) {y++;}
        if (direction == Direction.Back) {z--;}
        if (direction == Direction.Foward) {x++;}
    }

    @Override
    public void damage() {
        health--;
    }
}
