package pheonixTeam.main.entity.skills;

import pheonixTeam.main.entity.living.EntityLiving;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class Skill
{
    /**
     * Implement this in your skill class
     */
    public String name;

    /**
     * Implement in Skill class
     * @param entity
     */
    public abstract void doSkill(EntityLiving entity);

    /**
     * Checks if the entity has the skill
     * @param entity
     * @return boolean
     */
    public boolean checkIfEntityHasSkill(EntityLiving entity){
        for (Skill skill : entity.skills) {
            if (skill.name.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
