package phoenixTeam.entity.skills;

import com.badlogic.ashley.core.Entity;

/**
 * @author Strikingwolf, chbachman
 */
public class SkillFireball extends Skill
{
    public SkillFireball() {
    	super("Fireball");
    }

    @Override
    public void doSkill(Entity entity) {
    	
    	//TODO: Striking, fix this.
    	
    	/*
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
        */
    }
}
