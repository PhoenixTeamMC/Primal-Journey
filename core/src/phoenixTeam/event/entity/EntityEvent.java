package phoenixTeam.event.entity;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.event.CancellableBase;

/**
 * @author Strikingwolf
 */
public class EntityEvent extends CancellableBase {
	public Entity entity;
	public int time;

	EntityEvent(Entity entity) {
		this.entity = entity;
	}
}
