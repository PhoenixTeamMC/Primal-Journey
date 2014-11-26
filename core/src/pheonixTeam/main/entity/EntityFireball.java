package pheonixTeam.main.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pheonixTeam.main.Direction;
import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.map.Map;

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
        batch = new SpriteBatch();
        texture = new Texture("fireball.png");
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
