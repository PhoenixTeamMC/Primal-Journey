package phoenixTeam.entity.living.enemy;

import java.util.ArrayList;

import phoenixTeam.entity.Entity;
import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class EntityEnemy extends EntityLiving
{
    public Entity target;

    public float trackRangeX;
    public float trackRangeY;
    public float attackRangeX;
    public float attackRangeY;

    public int damageAmount;

    public EntityEnemy(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(Map map) {
        ArrayList<Entity> entitiesWithin = map.getEntitiesWithin(x, y, trackRangeX, trackRangeY);
        ArrayList<Entity> validTargets = new ArrayList<Entity>();
        for (Entity entity : entitiesWithin) {
            if (!(entity instanceof EntityEnemy)) {
                validTargets.add(entity);
            }
        }
        target = map.getClosestEntityOutOf(x, y, validTargets);
        if (target != null) {
        	
        	 moveCloserToEntity(target, moveSpeed);
        	 
            for (Entity entity : map.getEntitiesWithin(target.x, target.y, trackRangeX, trackRangeY)) {
                if (entity == this) {
                    if (target instanceof EntityLiving) {
                        attack(target);
                    }
                }
            }
        }
    }

    public abstract void attack(Entity entity);
}
