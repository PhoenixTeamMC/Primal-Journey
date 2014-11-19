package pheonixTeam.main.entity.interfaces;

import pheonixTeam.main.Direction;

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
}
