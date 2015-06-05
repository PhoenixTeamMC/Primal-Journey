package phoenixTeam.event.entity;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.event.CancellableBase;
import phoenixTeam.event.SignalBase;

/**
 * @author Strikingwolf
 */
public class EntityEvent extends CancellableBase {
	public static final SignalBase<EntityEvent> signal = new SignalBase<EntityEvent>();

	Entity entity;

	EntityEvent(Entity entity) {
		this.entity = entity;
	}
}
