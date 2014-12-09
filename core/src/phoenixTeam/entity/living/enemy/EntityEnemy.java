package phoenixTeam.entity.living.enemy;

import java.util.ArrayList;

import phoenixTeam.entity.Entity;
import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.map.Map;
import phoenixTeam.util.EntityUtil;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class EntityEnemy extends EntityLiving
{
    public Entity target;

    public float trackRange;
    public float attackRangeX;
    public float attackRangeY;

    public int damageAmount;

    public EntityEnemy(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(Map map) {
        ArrayList<Entity> entitiesWithin = map.getEntitiesWithin(x, y, trackRange, trackRange);
        ArrayList<Entity> validTargets = new ArrayList<Entity>();
        for (Entity entity : entitiesWithin) {
            if (!(entity instanceof EntityEnemy)) {
                validTargets.add(entity);
            }
        }
        target = map.getClosestEntityOutOf(x, y, validTargets);
        if (target != null) {
        	 moveCloserToEntity(target, moveSpeed);
        	 
        	 if(EntityUtil.isWithin(this, target, trackRange)){
        		 attack(target);
        	 }
            
        }
    }

    public abstract void attack(Entity entity);
}
