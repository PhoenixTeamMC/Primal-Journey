package pheonixTeam.main.entity.living.familiars;

import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public class EntityFamiliar extends EntityLiving
{
    public EntityLiving owner;

    /**
     * Sets owner
     * @param entity
     */
    public EntityFamiliar(EntityLiving entity) {
        super();
        owner = entity;
        entity.familiars.add(this);
    }

    /**
     * Updates familiar and makes it move toward owner
     * @param map
     */
    @Override
    public void update(Map map) {
        super.update(map);
        moveToEntity(owner, -5, 0);
    }
}
