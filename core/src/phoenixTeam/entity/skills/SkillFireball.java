package phoenixTeam.entity.skills;

import phoenixTeam.entity.EntityFireball;
import phoenixTeam.entity.enums.PrimaryClasses;
import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.entity.living.player.EntityPlayer;
import phoenixTeam.map.Map;

/**
 * @author Strikingwolf, chbachman
 */
public class SkillFireball extends Skill
{
    public SkillFireball() {
    	super("Fireball");
    }

    @Override
    public void doSkill(EntityLiving entity) {
        if (entity.mana >= 20) {
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                if (player.primaryClass == PrimaryClasses.MAGE) {
                    if (checkIfEntityHasSkill(entity, this)) {
                        Map.entityList.add(new EntityFireball(player.x, player.y, player.facing));
                        player.mana -= 20;
                    }
                }
            } else if (checkIfEntityHasSkill(entity, this)) {
                entity.map.spawnEntity(new EntityFireball(entity.x, entity.y, entity.facing));
                entity.mana -= 20;
            }
        }
    }
}
