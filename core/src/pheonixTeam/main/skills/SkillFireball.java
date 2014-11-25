package pheonixTeam.main.skills;

import pheonixTeam.main.EntityFireball;
import pheonixTeam.main.Map;
import pheonixTeam.main.entity.EntityLiving;
import pheonixTeam.main.entity.EntityPlayer;
import pheonixTeam.main.entity.enums.PrimaryClasses;

/**
 * @author Strikingwolf, chbachman
 */
public class SkillFireball extends Skill
{
    @Override
    public void doSkill(EntityLiving entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (player.primaryClass == PrimaryClasses.MAGE) {
                if (checkIfEntityHasSkill(entity)) {
                    Map.entityList.add(new EntityFireball(entity.x, entity.y, entity.z));
                }
            }
        } else if (checkIfEntityHasSkill(entity)) {
            Map.entityList.add(new EntityFireball(entity.x, entity.y, entity.z));
        }
    }
}
