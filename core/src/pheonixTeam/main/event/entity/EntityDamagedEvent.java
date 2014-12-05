package pheonixTeam.main.event.entity;

import pheonixTeam.main.entity.Entity;
import pheonixTeam.main.entity.living.EntityLiving;
import pheonixTeam.main.event.Event;

public class EntityDamagedEvent extends Event{
	
	public Entity entity;
	public int damage;
	
	public EntityDamagedEvent(EntityLiving entity, int damage){
		this.entity = entity;
		this.damage = damage;
	}
}
