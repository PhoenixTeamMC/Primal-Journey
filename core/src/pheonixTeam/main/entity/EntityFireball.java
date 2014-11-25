package pheonixTeam.main.entity;

import pheonixTeam.main.Direction;
import pheonixTeam.main.Map;
import pheonixTeam.main.entity.living.EntityLiving;

/**
 * @author Strikingwolf, chbachman
 */
public class EntityFireball extends Entity
{
    public int damageAmount = 5;

    public EntityFireball(float xPos, float yPos, Direction direction) {
        x = xPos;
        y = yPos;
        facing = direction;
    }

    @Override
    public void update(Map map){
        super.update(map);
        if (facing == Direction.RIGHT) {x++;}
        if (facing == Direction.LEFT) {x--;}
        if (facing == Direction.UP) {y++;}
        if (facing == Direction.DOWN) {y--;}
        Entity entity = map.getEntityAt(x, y);
        if (entity instanceof EntityLiving) {
            EntityLiving living = (EntityLiving) entity;
            living.damage(damageAmount);
            map.killEntity(this);
        }
    }
}
