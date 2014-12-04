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
    public float rangeX;
    public float rangeY;

    public EntityEnemy(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(Map map) {

    }
}
