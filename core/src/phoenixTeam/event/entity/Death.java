package phoenixTeam.event.entity;

import com.badlogic.ashley.core.Entity;

/**
 * @author Strikingwolf
 */
public class Death extends EntityEvent {
	public Death(Entity entity) {
		super(entity);
	}
}
