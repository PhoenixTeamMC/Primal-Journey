package pheonixTeam.main.skills;

import pheonixTeam.main.entity.EntityLiving;

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
        for (int i = 0; i < entity.skills.size() ; i++) {
            if (entity.skills.get(i).equals(this)) {
                return true;
            }
        }
        return false;
    }
}
