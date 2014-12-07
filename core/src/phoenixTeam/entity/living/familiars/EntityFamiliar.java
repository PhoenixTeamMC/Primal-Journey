package phoenixTeam.entity.living.familiars;

import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.event.map.OnTickEvent;
import phoenixTeam.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class EntityFamiliar extends EntityLiving
{
    public EntityLiving owner;

    /**
     * Makes entity
     * @param x
     * @param y
     * @param theOwner
     */
    public EntityFamiliar(float x, float y, EntityLiving theOwner) {
        super(x, y);
        owner = theOwner;
        theOwner.familiars.add(this);
    }

    /**
     * Updates familiar and makes it move toward owner
     * @param map
     */
    @Override
    public void update(Map map) {
        super.update(map);
        if (map.time % 2 == 0) {
            moveCloserToEntity(owner, moveSpeed, 0, 5, 5);
        } else {
            moveCloserToEntity(owner, 0, moveSpeed, 5, 5);
        }
    }
}
