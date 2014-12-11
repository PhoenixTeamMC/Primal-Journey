package phoenixTeam.entity.living.enemy;

import java.util.ArrayList;

import phoenixTeam.entity.EntityLiving;
import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.map.Map;
import phoenixTeam.util.EntityUtil;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class EntityEnemy extends EntityLiving
{
    public EntityLiving target;

    public float trackRange;
    public float attackRangeX;
    public float attackRangeY;

    public int damageAmount;

    public EntityEnemy(float x, float y) {
        super(x, y);
    }

    @Override
    public void update(Map map) {
    	super.update(map);
    	
    	if(target == null || target.isDead){
    		ArrayList<EntityLiving> entitiesWithin = EntityUtil.getEntitiesWithin(x, y, 10000, 100000);
            ArrayList<EntityLiving> validTargets = new ArrayList<EntityLiving>();
            for (EntityLiving entity : entitiesWithin) {
                if (!(entity instanceof EntityEnemy)) {
                    validTargets.add(entity);
                }
            }
            target = EntityUtil.getClosestEntityOutOf(x, y, validTargets);
    	}
    	
        if(target == null){
        	return;
        }
        
    	this.moveTo(target.x, target.y);
   	 
   	 if(EntityUtil.isWithin(this, target, trackRange)){
   		 attack(target);
   	 }
    }

    public abstract void attack(EntityLiving entity);
}
