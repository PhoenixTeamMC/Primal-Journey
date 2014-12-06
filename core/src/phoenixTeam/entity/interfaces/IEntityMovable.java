package phoenixTeam.entity.interfaces;

import phoenixTeam.entity.Entity;
import phoenixTeam.util.Direction;

/**
 * @author Strikingwolf
 */
public interface IEntityMovable
{
    /**
     * Used to move an entity
     * @param direction
     */
    public void move(Direction direction, float amount);

    /**
     * used to move to a point
     * @param x
     * @param y
     */
    public void moveTo(float x, float y);

    /**
     * Used to move to an entity
     * @param entity
     */
    public void moveToEntity(Entity entity, float withinX, float withinY);
}
