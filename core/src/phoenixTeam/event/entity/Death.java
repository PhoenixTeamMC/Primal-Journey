package phoenixTeam.event.entity;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.event.SignalBase;

/**
 * @author Strikingwolf
 */
public class Death extends EntityEvent {
	public static final SignalBase<Death> signal = new SignalBase<Death>();

	public Death(Entity entity) {
		super(entity);
	}
}
