package phoenixTeam.event.entity;

import phoenixTeam.entity.Entity;
import phoenixTeam.entity.living.EntityLiving;
import phoenixTeam.event.Event;

public class EntityDamagedEvent extends Event{
	
	public Entity entity;
	public int damage;
	
	public EntityDamagedEvent(EntityLiving entity, int damage){
		this.entity = entity;
		this.damage = damage;
	}
}
