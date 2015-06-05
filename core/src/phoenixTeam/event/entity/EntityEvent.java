package phoenixTeam.event.entity;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.event.CancellableBase;

/**
 * @author Strikingwolf
 */
public class EntityEvent extends CancellableBase {
	Entity entity;

	EntityEvent(Entity entity) {
		this.entity = entity;
	}
}
