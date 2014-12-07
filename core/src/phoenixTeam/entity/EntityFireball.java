package phoenixTeam.entity;

import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.event.map.OnTickEvent;
import phoenixTeam.map.Map;
import phoenixTeam.util.Direction;

/**
 * @author Strikingwolf, chbachman
 */
public class EntityFireball extends Entity
{
    public int damageAmount = 5;

    public EntityFireball(float xPos, float yPos, Direction direction) {
    	super(xPos, yPos);
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

	@Override
	public String getTextureLocation() {
		return "fireball.png";
	}
}
