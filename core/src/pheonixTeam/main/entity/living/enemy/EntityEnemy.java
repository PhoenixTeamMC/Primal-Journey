package pheonixTeam.main.entity.living.enemy;

import pheonixTeam.main.entity.Entity;
import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class EntityEnemy extends EntityLiving
{
    public Entity target;

    public EntityEnemy(float x, float y) {
        super(x, y);
    }
}
