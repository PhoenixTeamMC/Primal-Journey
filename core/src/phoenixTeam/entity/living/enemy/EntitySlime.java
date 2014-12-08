package phoenixTeam.entity.living.enemy;

import phoenixTeam.entity.Entity;
import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.util.Animation;
import phoenixTeam.util.TextureUtil;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * @author Strikingwolf, chbachman
 */
public class EntitySlime extends EntityLiving
{
	Animation animation;
	
    public EntitySlime(float x, float y) {
        super(x, y);

        moveSpeed = 1;
        //damageAmount = 1;
        //attackRangeX = 2;
        //attackRangeY = 2;
        //trackRangeX = 50;
        //trackRangeY = 50;
        
        animation = new Animation(TextureUtil.getTexture("slime.png"), 4, 1, .25F);
    }

    /*
    @Override
    public void attack(Entity entity) {
        int rand = random.nextInt(100);
        if (rand % 7 == 0) {
            entity.damage(damageAmount * 2);
        } else {
            entity.damage(damageAmount);
        }
    }
	*/

    @Override
    public String getTextureLocation() {
        return "slime.png";
    }

	@Override
	public void display(Batch batch) {
		//super.display(batch);
		animation.display(batch, x, y, 10, 10);
	}
    
    
}
