package phoenixTeam.event.entity;

import com.badlogic.ashley.core.Entity;

/**
 * @author Strikingwolf
 */
public class AfterDeath extends EntityEvent {
	public AfterDeath(Entity entity) {
		super(entity);
	}
}
