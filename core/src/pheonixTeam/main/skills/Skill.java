package pheonixTeam.main.skills;

import pheonixTeam.main.entity.EntityLiving;

/**
 * @author Strikingwolf, chbachman
 */
public abstract class Skill
{
    public String name;

    /**
     * Implement in Skill class
     * @param entity
     */
    public abstract void doSkill(EntityLiving entity);

    public boolean checkIfEntityHasSkill(EntityLiving entity){
        for (int i = 0; i < entity.skills.size() ; i++) {
            if (entity.skills.get(i).equals(this)) {
                return true;
            }
        }
        return false;
    }
}
