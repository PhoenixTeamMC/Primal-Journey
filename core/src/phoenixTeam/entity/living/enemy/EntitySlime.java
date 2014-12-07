package phoenixTeam.entity.living.enemy;

import phoenixTeam.entity.Entity;

/**
 * @author Strikingwolf, chbachman
 */
public class EntitySlime extends EntityEnemy
{
    public EntitySlime(float x, float y) {
        super(x, y);

        moveSpeed = 1;
        damageAmount = 1;
        attackRangeX = 2;
        attackRangeY = 2;
        trackRangeX = 50;
        trackRangeY = 50;
    }

    @Override
    public void attack(Entity entity) {
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
}
