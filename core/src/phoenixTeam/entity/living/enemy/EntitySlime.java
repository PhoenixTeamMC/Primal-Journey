package phoenixTeam.entity.living.enemy;

import phoenixTeam.entity.EntityLiving;
import phoenixTeam.util.Animation;
import phoenixTeam.util.TextureUtil;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * @author Strikingwolf, chbachman
 */
public class EntitySlime extends EntityEnemy
{
	Animation animation;
	
    public EntitySlime(float x, float y) {
        super(x, y);

        moveSpeed = 1;
        damageAmount = 1;
        attackRangeX = 2;
        attackRangeY = 2;
        trackRange = 5;
        
        animation = new Animation(TextureUtil.getTexture("slime.png"), 4, 1, .1F);
    }

    
    @Override
    public void attack(EntityLiving entity) {
        int rand = random.nextInt(100);
        if (rand % 7 == 0) {
            entity.damage(damageAmount * 2);
        } else {
            entity.damage(damageAmount);
        }
    }
	

    @Override
    public String getTextureLocation() {
        return "slime.png";
    }

	@Override
	public void display(Batch batch) {
		animation.display(batch, x, y, 10, 10);
	}
    
    
}
