 package phoenixTeam.entity.living;

 import java.util.ArrayList;
import java.util.List;

import phoenixTeam.entity.Entity;
import phoenixTeam.entity.interfaces.IEntityMovable;
import phoenixTeam.entity.living.familiars.EntityFamiliar;
import phoenixTeam.entity.skills.Skill;
import phoenixTeam.event.entity.EntityDamagedEvent;
import phoenixTeam.util.Direction;
import phoenixTeam.util.Random;

/**
 * @author Strikingwolf, CBachman
 */
public abstract class EntityLiving extends Entity implements IEntityMovable
{
    //Mana
    public int mana = 20;

    public List<EntityFamiliar> familiars = new ArrayList<EntityFamiliar>();

    public int skillWanted = 0;
    public List<Skill> skills = new ArrayList<Skill>();

    public Random random = new Random();
    
    public EntityLiving(float x, float y) {
		super(x, y);
	}
}
