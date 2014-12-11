package phoenixTeam.event.entity;

import phoenixTeam.entity.EntityLiving;
import phoenixTeam.event.Event;

public class EntityDamagedEvent extends Event{
	
	public EntityLiving entity;
	public int damage;
	
	public EntityDamagedEvent(EntityLiving entity, int damage){
		this.entity = entity;
		this.damage = damage;
	}
}
