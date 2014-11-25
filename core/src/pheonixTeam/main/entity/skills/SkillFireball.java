package pheonixTeam.main.entity.skills;

import pheonixTeam.main.Map;
import pheonixTeam.main.entity.EntityFireball;
import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.entity.living.EntityPlayer;
import pheonixTeam.main.entity.enums.PrimaryClasses;

/**
 * @author Strikingwolf, chbachman
 */
public class SkillFireball extends Skill
{
    public SkillFireball() {
        name = "Fireball";
    }

    @Override
    public void doSkill(EntityLiving entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (player.primaryClass == PrimaryClasses.MAGE) {
                if (checkIfEntityHasSkill(entity)) {
                    Map.entityList.add(new EntityFireball(entity.x, entity.y, player.facing));
                }
            }
        } else if (checkIfEntityHasSkill(entity)) {
            entity.map.spawnEntity(new EntityFireball(entity.x, entity.y, entity.facing));
        }
    }
}
