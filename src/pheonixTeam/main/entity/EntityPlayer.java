package pheonixTeam.main.entity;

import pheonixTeam.main.entity.enums.PrimaryClasses;
import pheonixTeam.main.entity.enums.Races;
import pheonixTeam.main.entity.enums.SecondaryClasses;

/**
 * @author Strikingwolf
 */
public class EntityPlayer extends EntityLiving
{
    //Race
    public Races race = Races.NONE;

    //Class
    public PrimaryClasses primaryClass = PrimaryClasses.NONE;
    public SecondaryClasses secondaryClass = SecondaryClasses.NONE;

    //Stats
    int constitution;
    int strength;
    int dexterity;
    int wisdom;

    //Skills
    //TODO
}
