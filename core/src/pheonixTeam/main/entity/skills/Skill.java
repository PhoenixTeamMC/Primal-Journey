package pheonixTeam.main.entity.skills;

import pheonixTeam.main.entity.EntityLiving;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class Skill
{
    /**
     * Implement this in your skill class
     */
    public static String name;

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
    public static boolean checkIfEntityHasSkill(EntityLiving entity){
        for (int i = 0; i < entity.skills.size() ; i++) {
            if (entity.skills.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
